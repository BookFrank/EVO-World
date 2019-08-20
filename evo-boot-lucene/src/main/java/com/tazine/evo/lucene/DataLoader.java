package com.tazine.evo.lucene;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author frank
 * @date 2019/08/20
 */
public class DataLoader {

    public static void main(String[] args) throws IOException {
        cityGeoInfoList();
    }

    public static List<CityGeoInfo> cityGeoInfoList() throws IOException {
        List<CityGeoInfo> cityGeoInfoList = Lists.newArrayList();

        String cp = DataLoader.class.getResource("/").getPath();
        List<CityGeoInfo> list = Lists.newArrayList();
        Path path = Paths.get(cp + "/geo.txt");
        List<String> cont = FileUtils.readLines(path.toFile(), Charset.defaultCharset());
        for (int i = 0; i < cont.size(); i++) {
            String c = cont.get(i);

            String name = c.split(":")[0];
            List<String> coors = Splitter.on(",").splitToList(c.split(":")[1]);

            CityGeoInfo cityGeoInfo = new CityGeoInfo();
            cityGeoInfo.setCityId((long)(i + 1));
            cityGeoInfo.setName(name);
            cityGeoInfo.setLnt(Double.parseDouble(coors.get(0)));
            cityGeoInfo.setLat(Double.parseDouble(coors.get(1)));

            cityGeoInfoList.add(cityGeoInfo);
            //System.out.println(JSON.toJSONString(cityGeoInfo));
        }
        return cityGeoInfoList;
    }
}
