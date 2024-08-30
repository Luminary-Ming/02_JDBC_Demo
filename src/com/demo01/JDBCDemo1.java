package com.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 编写 JDBC 的步骤
 * 1. 加载数据库的驱动
 * 2. 获取数据库的链接
 * 3. 执行 SQL 语句
 * 4. 处理执行的结果
 * 5. 释放数据库的资源
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1. 加载数据库驱动，加载使用的某个数据库实现了 JDBC 的核心类
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 编写连接数据库的 URL 地址
        String url = "jdbc:mysql://127.0.0.1:3306/emp_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai\";";
        // 2. 获取数据库
        Connection conn = DriverManager.getConnection(url, "root", "leesin");
        // 3. 得到一个执行 sql 的执行器
        Statement stmt = conn.createStatement();
        String sql = "insert into demo(id,name,sex,hobby) values(null,'小鬼','男','泰裤辣！')";
        // 4. 执行 sql （增删改使用 executeUpdate ）
        int x = stmt.executeUpdate(sql);
        System.out.println(x);
        // 5. 关闭（释放）各种资源
        stmt.close();
        conn.close();
    }
}
