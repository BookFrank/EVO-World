package com.tazine.evo.db;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.db.mapper.PlayerMapper;
import com.tazine.evo.db.model.Player;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MybatisXMLTest
 *
 * @author frank
 * @date 2019/06/12
 */
public class MybatisXmlTest {

    @Test
    public void playerTest() {

        String res = "mybatis-config.xml";
        InputStream inputStream = null;

        // 1. 根据 XML 或者注解构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = null;
        try {
            // 1.1 构建所需的 DataSource 等对象已在 XML 中完成配置
            inputStream = Resources.getResourceAsStream(res);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 2. 打开 SqlSession 会话，并执行 SQL
            SqlSession sqlSession = sqlSessionFactory.openSession();

            // 2.1 使用动态代理获得 mapper 实现
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            //Player result = playerMapper.getPlayerByName("kobe");
            List<Player> result = playerMapper.list();
            sqlSession.commit();

            if (null != result) {
                result.forEach(v -> {
                    System.out.println(v.getName());
                });
                System.out.println(JSON.toJSONString(result));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
