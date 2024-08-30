package com.demo01;

import com.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/user_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
        Connection conn = DriverManager.getConnection(url, "root", "leesin");
        String sql = "select * from users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        // 定义一个 List 集合，用于存储查询到的所有实体数据。
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            // 在遍历结果集的时候，一般都需要手动将数据封装到某个Java对象中，或者存储到某个集合中
            User user = new User();
            user.setId(rs.findColumn("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAddress(rs.getString("address"));
            // 将封装的 User 对象存储在 List 集合
            users.add(user);
        }
        System.out.println(users);
        // 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
