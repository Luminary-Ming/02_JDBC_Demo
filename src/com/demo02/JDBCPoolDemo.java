package com.demo02;

import cn.hutool.db.DbUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库连接池的使用
 */
public class JDBCPoolDemo {
    @Test
    public void demo() throws SQLException {
        // 连接池对象（容器）
        DruidDataSource ds = new DruidDataSource();
        // 设置基本的参数
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/user_demo");
        ds.setUsername("root");
        ds.setPassword("leesin");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // ...params：可变参数
        List<User> users = DbUtil.use(ds).query("select * from users where id = ?", User.class, 10006);
        System.out.println(users);
    }

    @Test
    public void demo2() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/user_demo");
        ds.setUsername("root");
        ds.setPassword("leesin");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // 使用 hutoll 包中的关于数据库操作的工具类，快速对数据库进行 CRUD 操作
        int x = DbUtil.use(ds).execute("delete from users where id in(?, ?, ?, ?, ?)", 5, 6, 7, 8, 9);
        System.out.println(x);
    }
}
/**
 * CRUD 介绍
 * 1. 创建（create） 指 insert
 * 2. 读取（read）  指 select
 * 3. 更新（update）
 * 4. 删除（delete）
 */