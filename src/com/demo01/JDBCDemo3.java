package com.demo01;


import com.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 标准的 JDBC 编写
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 加载数据库的驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取数据库的连接
            // String url, String user, String password
            String url = "jdbc:mysql://127.0.0.1:3306/user_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
            // 多态：父类或者接口引用 指向子类或实现类的对象  ConnectionImpl 类的对象
            conn = DriverManager.getConnection(url, "root", "leesin");
            // 准备sql语句
            String sql = "select * from users";
            // 获取jdbc中用于执行sql的对象（sql执行器）
            stmt = conn.createStatement();
            // 执行查询操作，返回查询的结果集对象
            rs = stmt.executeQuery(sql);
            // 定义一个List集合，用于存储查询到的所有的实体数据
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.findColumn("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                // 将封装的 User 对象存储在 List 集合
                users.add(user);
            }
            System.out.println(users);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    stmt = null;
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    conn = null;
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
