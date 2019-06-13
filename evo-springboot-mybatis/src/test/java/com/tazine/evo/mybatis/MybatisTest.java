package com.tazine.evo.mybatis;

import com.tazine.evo.mybatis.mapper.PlayerMapper;
import com.tazine.evo.mybatis.model.Player;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author frank
 * @date 2019/06/12
 */
public class MybatisTest {


    @Test
    public void playerTest(){

        String res = "mybatis-config.xml";
        InputStream inputStream = null;

        SqlSessionFactory sqlSessionFactory = null;
        try {
            inputStream = Resources.getResourceAsStream(res);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            List<Player> result = playerMapper.listPlayer();
            sqlSession.commit();

            if (null != result){
                result.forEach(v -> {
                    System.out.println(v.getName());
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
