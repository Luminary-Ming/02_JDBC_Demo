package com.demo02;

import java.sql.*;

/**
 * 封装关于 JDBC 操作的时候，驱动的加载、链接的获取、资源的释放等公共操作
 * JDBCUtils：JDBC 的工具类，它中提供的方法，基本都是静态
 */
public class JDBCUtils {
    private static Connection conn;

    static {
        try {
            // 类加载的时候只执行一次
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/user_demo", "root", "leesin");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提供一个方法，对外暴露数据库的连接
     */
    public static Connection getConnection() {
        return conn;
    }

    /**
     * 释放资源
     */
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt,null);
    }

    /**
     * 释放资源
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
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