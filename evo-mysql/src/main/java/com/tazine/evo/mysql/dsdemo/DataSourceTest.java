package com.tazine.evo.mysql.dsdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DataSourceTest
 *
 * @author frank
 * @date 2019/1/13
 */
public class DataSourceTest {

    public static void main(String[] args) throws Exception {

        EvoDatasource datasource = new EvoDatasource();

        Connection conn = datasource.getConnection();

        Statement st = conn.createStatement();

        String sql = "SELECT * FROM player";

        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        datasource.freeConnection(conn);
    }
}
