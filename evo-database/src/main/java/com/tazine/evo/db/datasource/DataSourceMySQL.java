package com.tazine.evo.db.datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

/**
 * DataSource 方式连接操作数据库
 *
 * @author jiaer.ly
 * @date 2020/04/07
 */
public class DataSourceMySQL {

    public static void main(String[] args) {

        MysqlDataSource dataSource;
        Connection connection;

        dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("evo-mysql");
        dataSource.setUser("root");
        dataSource.setPassword("jiaer.ly");
        dataSource.setPort(3306);

        try {
            connection = dataSource.getConnection();
            if (!connection.isClosed()){
                System.out.println("Succeed connecting to the MySQL");
            }

            Statement st = connection.createStatement();

            String sql = "SELECT * FROM tb_nba_player";
            PreparedStatement ps1 = connection.prepareStatement(sql);

            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-"+rs.getString("name") + "-" + rs.getInt("num") + "-" + rs.getString("team"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
