package com.tazine.evo.mysql;


import java.sql.*;

/**
 * JDBC MySQL 数据库
 *
 * @author frank
 * @date 2018/1/13
 */
public class JdbcMySQL {

    public static void main(String[] args) {

        try {
            // 1. 加载数据库驱动程序，就是加载其对 JDBC 接口的实现，注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");

            // 3. 创建执行语句的 statement
            String name = "harden";
            String sql = "delete from player where name='" + name + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            //存在sql注入的危险
            //如果用户传入的id为“5 or 1=1”，那么将删除表中的所有记录

            //PreparedStatement 有效的防止sql注入(SQL语句在程序运行前已经进行了预编译,当运行时动态地把参数传给PrepareStatement时，即使参数里有敏感字符如 or '1=1'也数据库会作为一个参数一个字段的属性值来处理而不会作为一个SQL指令)
            String sql1 = "insert into player (name,number,team ) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql1);
            // 占位符顺序从1开始
            ps.setString(1, "james harden");
            // 也可以使用setObject
            ps.setInt(2, 3);
            ps.setString(3,"rockets");
            ps.executeUpdate();

            String sql2 = "SELECT * FROM player";
            PreparedStatement ps1 = conn.prepareStatement(sql2);

            // 4. 处理执行结果
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "-"+rs.getString("name") + "-" + rs.getInt("number") + "-" + rs.getString("team"));
            }

            // 5. 释放资源
            //数据库连接（Connection）非常耗资源，尽量晚创建，尽量早的释放
            //都要加try catch 以防前面关闭出错，后面的就不执行了
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
