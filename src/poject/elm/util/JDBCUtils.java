package poject.elm.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 */
public class JDBCUtils {

    private static final DruidDataSource ds = new DruidDataSource();

    static {
        // 初始化数据库连接池
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_elm");
        ds.setUsername("root");
        ds.setPassword("leesin");
    }

    /**
     * 获得数据源
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获得数据库连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
