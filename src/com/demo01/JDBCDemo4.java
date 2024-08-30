package com.demo01;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo4 {

    /**
     * 插入数据
     */
    @Test
    public void testInsert() throws Exception {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo" +
                "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "leesin");
        // 获取执行器
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("insert into users values(null,'弗雷尔卓德之心','flezdzx','费雷尔卓德')");
        if (i > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
        // 释放资源
        stmt.close();
        conn.close();
    }

    /**
     * 删除数据
     */
    @Test
    public void testDelete() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "leesin");
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("delete from users where id = 1");
        if (i > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        stmt.close();
        conn.close();
    }

    /**
     * 修改数据
     */
    @Test
    public void testUpdate() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "leesin");
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("update users set username = '诺克萨斯之手',password = 'nksszs',address = '诺克萨斯' where id = 2");
        if (i > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        stmt.close();
        conn.close();
    }

    /**
     * 查询数据
     */
    @Test
    public void testSelect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "leesin");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users where username like '%诺%'");
        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
            System.out.println(rs.getString("address"));
        }
        stmt.close();
        conn.close();
    }
}
