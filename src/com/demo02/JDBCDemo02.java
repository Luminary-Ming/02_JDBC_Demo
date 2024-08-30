package com.demo02;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * 使用 hutool.jar 包的Db或者DbUtil工具类，配合Druid连接池完成表的CRUD操作
 */
public class JDBCDemo02 {

    /**
     * 添加操作
     */
    @Test
    public void testInsert() throws SQLException {
        // 连接池对象（容器）
        DruidDataSource ds = new DruidDataSource();
        // 设置基本的参数
        ds.setUrl("jdbc:mysql://127.0.0.1/user_demo");
        ds.setUsername("root");
        ds.setPassword("leesin");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        DbUtil.use(ds).insert(
                Entity.create("users")
                        .set("username","疾风剑豪")
                        .set("password","EEEEEEEE")
                        .set("address","艾欧尼亚")
        );
    }


    /**
     * 删除操作
     */
    @Test
    public void testDelete() throws SQLException {
        // 连接池对象（容器）
        DruidDataSource ds = new DruidDataSource();
        // 设置基本的参数
        ds.setUrl("jdbc:mysql://127.0.0.1/user_demo");
        ds.setUsername("root");
        ds.setPassword("leesin");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        DbUtil.use(ds).del(
                Entity.create("users")
                        .set("username","沃利贝尔")
        );
    }


    /**
     * 修改操作
     */
    @Test
    public void testUpdate() throws SQLException {
        // 连接池对象（容器）
        DruidDataSource ds = new DruidDataSource();
        // 设置基本的参数
        ds.setUrl("jdbc:mysql://127.0.0.1/user_demo");
        ds.setUsername("root");
        ds.setPassword("leesin");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        DbUtil.use(ds).update(
                Entity.create().set("username", "祖安怒兽").set("address", "祖安").set("password", "zans"),
                Entity.create("users").set("id", 10006)
        );
    }

    /**
     * 查询操作
     */
    @Test
    public void testSelect() throws SQLException {
        // 连接池对象（容器）
        DruidDataSource ds = new DruidDataSource();
        // 设置基本的参数
        ds.setUrl("jdbc:mysql://127.0.0.1/user_demo");
        ds.setUsername("root");
        ds.setPassword("leesin");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        Entity entity = Db.use(ds).queryOne("select * from users where id = ?", 10086);
        System.out.println(entity.getStr("username"));
        System.out.println(entity.getStr("address"));
    }
}
