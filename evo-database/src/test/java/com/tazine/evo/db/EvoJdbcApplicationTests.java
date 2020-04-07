package com.tazine.evo.db;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.db.model.Player;
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
import java.sql.Statement;
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
        List<Player> players = jdbcTemplate.query(sql, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet rs, int i) throws SQLException {
                Player player = new Player();
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
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM player";
            ResultSet rt = st.executeQuery(sql);
            while (rt.next()) {
                System.out.println(rt.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
