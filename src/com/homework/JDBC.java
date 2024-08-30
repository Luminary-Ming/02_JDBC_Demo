package com.homework;


import org.junit.jupiter.api.Test;

import java.sql.*;


/**
 * jdbc 四级项目 1
 */
public class JDBC {
    /**
     * 张三的生日更新为当前系统时间
     */
    @Test
    public void update() throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库的连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo" +
                "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "leesin");
        // 获取执行器
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("update user set birthday = now() where name = '张三'");
        if (i > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        stmt.close();
        conn.close();
    }

    /**
     * 删除名为王五的全部记录
     */
    @Test
    public void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo" +
                "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "leesin");
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("delete from user where name = '王五'");
        if (i > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        stmt.close();
        conn.close();
    }

    /**
     * 查询"1987"以后出生的用户信息
     */
    @Test
    public void select() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_demo" +
                "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "leesin");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user where birthday > '1987-1-1' ;");
        while (rs.next()) {
            System.out.print(rs.getString("name") + " ");
            System.out.print(rs.getString("pwd") + " ");
            System.out.print(rs.getString("email") + " ");
            System.out.print(rs.getString("birthday") + " ");
            System.out.print(rs.getString("money") + "\n");
        }
        stmt.close();
        conn.close();
    }
}
