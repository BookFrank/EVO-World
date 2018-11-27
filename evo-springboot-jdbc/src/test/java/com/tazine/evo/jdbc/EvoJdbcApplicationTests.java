package com.tazine.evo.jdbc;

import com.tazine.evo.jdbc.entity.NbaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author frank
 * @date 2018/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvoJdbcApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void mysqlTest(){

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
}
