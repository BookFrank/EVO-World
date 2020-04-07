package com.tazine.evo.db.mybatis.annotated;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.db.mybatis.Player;
import com.tazine.evo.db.mybatis.annotated.mapper.PlayerMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * 不使用 XML 配置
 *
 * @author jiaer.ly
 * @date 2020/04/07
 */
public class Test {

    public static void main(String[] args) {
        //创建连接池
        DataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver",
            "jdbc:mysql://127.0.0.1:3306/evo-mysql", "root", "jiaer.ly");
        //事务
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //创建环境
        Environment environment = new Environment("development", transactionFactory, dataSource);

        //创建配置
        Configuration configuration = new Configuration(environment);
        //开启驼峰规则
        configuration.setMapUnderscoreToCamelCase(true);
        //加入资源（Mapper接口）
        configuration.addMapper(PlayerMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
            .build(configuration);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            //statement:sql唯一标识(mapper.xml映射文件中的id标识)
            //parament:参数
            Player user = session.selectOne("com.tazine.evo.db.mybatis.annotated.mapper.PlayerMapper.findById", 2);
            System.out.println(JSON.toJSONString(user));
            //操作数据时，需要有提交操作
            session.commit();
        } finally {
            session.close();
        }
    }
}
