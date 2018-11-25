package com.tazine.evo.boot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC(Java Data Base Connectivity)，是一种用于执行SQL语句的 Java API
 *
 * @author frank
 * @date 2018/11/09
 */
public class JdbcDemo {

    // JDBC 驱动名称与数据库 URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // 数据库用户名与密码
    private static final String USERNAME = "root";
    private static final String PASSWORD = "jiaer.ly";

    public static void main(String[] args) {

        try {
            // 1. 加载驱动程序，在 DriverManager.registerDriver 中注册驱动
            Class.forName(JDBC_DRIVER);

            // 2.
            System.err.println("获取数据库连接");
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // 3.
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM customer";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("id") + "-" + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
