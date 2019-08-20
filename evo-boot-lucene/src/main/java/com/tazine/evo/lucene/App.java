package com.tazine.evo.lucene;

import com.google.common.collect.Lists;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queries.function.ValueSource;
import org.apache.lucene.search.*;
import org.apache.lucene.spatial.SpatialStrategy;
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
import org.apache.lucene.spatial.prefix.tree.SpatialPrefixTree;
import org.apache.lucene.spatial.query.SpatialArgs;
import org.apache.lucene.spatial.query.SpatialOperation;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.shape.Point;
import org.locationtech.spatial4j.shape.Shape;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    /**
     * Spatial4j上下文
     * 1: SpatialContext初始化可由SpatialContextFactory配置
     * 2: SpatialContext属性
     * DistanceCalculator(默认使用GeodesicSphereDistCalc.Haversine,将地球视为标准球体) ShapeFactory(默认使用ShapeFactoryImpl)
     * Rectangle(构建经纬度空间:RectangleImpl(-180, 180, -90, 90, this)) BinaryCodec()
     */
    private SpatialContext ctx;

    /**
     * 索引和查询模型的策略接口
     */
    private SpatialStrategy strategy;

    /**
     * 索引存储目录
     */
    private Directory directory;

    protected void init() {
        /**
         * SpatialContext也可以通过SpatialContextFactory工厂类来构建
         * */
        this.ctx = SpatialContext.GEO;

        /**
         * 网格最大11层或Geo Hash的精度
         * 1: SpatialPrefixTree定义的Geo Hash最大精度为24
         * 2: GeohashUtils定义类经纬度到Geo Hash值公用方法
         * */
        SpatialPrefixTree spatialPrefixTree = new GeohashPrefixTree(ctx, 11);

        /**
         * 索引和搜索的策略接口,两个主要实现类
         * 1: RecursivePrefixTreeStrategy(支持任何Shape的索引和检索)
         * 2: TermQueryPrefixTreeStrategy(仅支持Point Shape)
         * 上述两个类继承PrefixTreeStrategy(有使用缓存)
         * */
        this.strategy = new RecursivePrefixTreeStrategy(spatialPrefixTree, "location");
        // 初始化索引目录
        this.directory = new RAMDirectory();
    }

    protected void createIndex(List<CityGeoInfo> cityGeoInfos) throws Exception {
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, config);
        indexWriter.addDocuments(newSampleDocument(ctx, strategy, cityGeoInfos));
        indexWriter.close();
    }

    /**
     * 创建Document索引对象
     */
    protected List<Document> newSampleDocument(SpatialContext ctx, SpatialStrategy strategy,
                                               List<CityGeoInfo> cityGeoInfos) {
        List<Document> documents = Lists.newLinkedList(cityGeoInfos.stream()
            .map(cgi -> {
                Document doc = new Document();
                doc.add(new StoredField("id", cgi.getCityId()));
                doc.add(new NumericDocValuesField("id", cgi.getCityId()));
                doc.add(new StringField("city", cgi.getName(), Field.Store.YES));
                Shape shape = null;
                /**
                 * 对小于MaxLevel的Geo Hash构建Field(IndexType[indexed,tokenized,omitNorms])
                 * */
                Field[] fields = strategy.createIndexableFields((shape = ctx.getShapeFactory()
                    .pointXY(cgi.getLnt(), cgi.getLat())));
                for (Field field : fields) {
                    doc.add(field);
                }
                Point pt = (Point)shape;
                doc.add(new StoredField(strategy.getFieldName(), pt.getX() + "," + pt.getY()));
                return doc;
            })
            .collect(Collectors.toList()));
        return documents;
    }

    /**
     * 地理位置搜索
     *
     * @throws Exception
     */
    public void search() throws Exception {
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        /**
         * 按照id升序排序
         * */
        Sort idSort = new Sort(new SortField("id", SortField.Type.INT));

        /**
         * 搜索方圆100千米范围以内,以当前位置经纬度(120.33,36.07)青岛为圆心,其中半径为100KM
         * */
        SpatialArgs args = new SpatialArgs(SpatialOperation.Intersects,
            ctx.getShapeFactory()
                .circle(120.33, 36.07, DistanceUtils.dist2Degrees(100, DistanceUtils.EARTH_MEAN_RADIUS_KM)));
        Query query = strategy.makeQuery(args);
        TopDocs topDocs = indexSearcher.search(query, 10, idSort);
        /**
         * 输出命中结果
         * */
        printDocument(topDocs, indexSearcher, args.getShape().getCenter());

        System.out.println("==========================华丽的分割线=========================");

        /**
         * 定义坐标点(x,y)即(经度,纬度)即当前用户所在地点(烟台)
         * */
        Point pt = ctx.getShapeFactory().pointXY(121.39, 37.52);

        /**
         * 计算当前用户所在坐标点与索引坐标点中心之间的距离即当前用户地点与每个待匹配地点之间的距离,DEG_TO_KM表示以KM为单位
         * 对Field(name=location)字段检索
         * */
        ValueSource valueSource = strategy.makeDistanceValueSource(pt, DistanceUtils.DEG_TO_KM);

        /**
         * 根据命中点与当前位置坐标点的距离远近降序排,距离数字大的排在前面,false表示降序,true表示升序
         * */
        Sort distSort = new Sort(valueSource.getSortField(false)).rewrite(indexSearcher);
        TopDocs topdocs = indexSearcher.search(new MatchAllDocsQuery(), 10, distSort);
        printDocument(topdocs, indexSearcher, pt);
        indexReader.close();
    }

    protected void printDocument(TopDocs topDocs, IndexSearcher indexSearcher, Point point) throws Exception {
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int docId = scoreDoc.doc;
            Document document = indexSearcher.doc(docId);
            int cityId = document.getField("id").numericValue().intValue();
            String city = document.getField("city").stringValue();
            String location = document.getField(strategy.getFieldName()).stringValue();
            String[] locations = location.split(",");
            double xPoint = Double.parseDouble(locations[0]);
            double yPoint = Double.parseDouble(locations[1]);
            double distDEG = ctx.calcDistance(point, xPoint, yPoint);
            double juli = DistanceUtils.degrees2Dist(distDEG, DistanceUtils.EARTH_MEAN_RADIUS_KM);
            System.out.println(
                "docId=" + docId + "\tcityId=" + cityId + "\tcity=" + city + "\tdistance=" + juli + "KM");
        }
    }

    public static void main(String[] args) throws Exception {
        App luceneSpatial = new App();
        luceneSpatial.init();
        luceneSpatial.createIndex(DataLoader.cityGeoInfoList());
        luceneSpatial.search();
    }
}
