package com.tazine.evo.mysql.dsdemo;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 自定义 DataSource
 *
 * @author frank
 * @date 2019/1/13
 */
public class EvoDatasource implements DataSource {

    private static final LinkedList<Connection> pool = new LinkedList<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建数据源时建立固定数量的数据库连接
     */
    public EvoDatasource() {
        for (int i = 0; i < 10; i++) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
                pool.add(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从连接池中获取一个连接
     *
     * @return Connection
     * @throws SQLException e
     */
    @Override
    public Connection getConnection() throws SQLException {
        System.out.println("从数据源获取连接");
        return pool.removeFirst();
    }

    /**
     * 释放连接
     *
     * @param connection Connection
     */
    public void freeConnection(Connection connection) {
        System.out.println("释放连接");
        pool.addLast(connection);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
