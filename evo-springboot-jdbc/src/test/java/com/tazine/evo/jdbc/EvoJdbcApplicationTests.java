package com.tazine.evo.jdbc;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.jdbc.entity.NbaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBC相关测试
 *
 * @author frank
 * @date 2018/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvoJdbcApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    public void jdbcTest() {
        String sql = "SELECT * FROM player";
        List<NbaPlayer> players = jdbcTemplate.query(sql, new RowMapper<NbaPlayer>() {
            @Override
            public NbaPlayer mapRow(ResultSet rs, int i) throws SQLException {
                NbaPlayer player = new NbaPlayer();
                player.setName(rs.getString("name"));
                player.setNum(rs.getInt("num"));
                player.setTeam(rs.getString("team"));
                return player;
            }
        });

        players.forEach(v -> {
            System.out.println(v.getName() + " - " + v.getTeam() + " - " + v.getNum());
        });
    }

    /**
     * SpringBoot2.x 的默认数据源为HikariDataSource
     */
    @Test
    public void dataSourceTest() {
        System.out.println(dataSource.toString());
        System.out.println(dataSource.getClass().getName());
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            System.out.println(JSON.toJSONString(conn.getClientInfo()));
            System.out.println(conn.getMetaData().getDatabaseProductName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
