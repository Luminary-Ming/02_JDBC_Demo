package poject.elm.dao.impl;

import cn.hutool.db.Db;
import com.homework.JDBC;
import poject.elm.dao.BusinessDao;
import poject.elm.pojo.Business;
import poject.elm.util.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {

    /**
     * 商家登录
     */
    @Override
    public Business businessLogin(String businessName, String password) throws SQLException {
        // 数据库连接
        Connection conn = JDBCUtils.getConnection();
        //TODO 试一下糊涂包写法
        String sql = "select * from  business where business_name = ? and password = ?";
        // sql 语句执行器
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 赋值给占位符
        stmt.setString(1, businessName);
        stmt.setString(2, password);
        // 执行查询后的结果集
        ResultSet rs = stmt.executeQuery();
        // 如果查询到有结果
        if (rs.next()) {
            // 把结果的数据赋值给 business 对象
            Business business = new Business();
            business.setBusinessId(rs.getInt("business_id"));
            business.setBusinessName(rs.getString("business_name"));
            business.setPassword(rs.getString("password"));
            business.setBusinessAddress(rs.getString("business_address"));
            business.setBusinessExplain(rs.getString("business_explain"));
            business.setStartPrice(rs.getDouble("start_price"));
            business.setDeliveryPrice(rs.getDouble("delivery_price"));
            return business;
        }
        // 登录失败
        return null;
    }

    /**
     * 商家注册
     */
    @Override
    public Boolean businessRegister(Business business) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into business values(null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, business.getPassword());
        stmt.setString(2, business.getBusinessName());
        stmt.setString(3, business.getBusinessAddress());
        stmt.setString(4, business.getBusinessExplain());
        stmt.setDouble(5, business.getStartPrice());
        stmt.setDouble(6, business.getDeliveryPrice());

        // sql 语句行计数
        int i = stmt.executeUpdate();
        return i > 0;
    }

    /**
     * 商家修改个人信息
     */
    @Override
    public Boolean updateBusiness(Business business) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "update business set password = ? , business_name = ? , business_address = ? ," +
                " business_explain = ? , start_price = ? , delivery_price = ? where business_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, business.getPassword());
        stmt.setString(2, business.getBusinessName());
        stmt.setString(3, business.getBusinessAddress());
        stmt.setString(4, business.getBusinessExplain());
        stmt.setDouble(5, business.getStartPrice());
        stmt.setDouble(6, business.getDeliveryPrice());
        stmt.setInt(7, business.getBusinessId());
        int i = stmt.executeUpdate();
        return i > 0;
    }

    /**
     * 管理员查询所有商家信息
     */
    @Override
    public List<Business> businessAll() throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        List<Business> query = Db.use(ds).query("select * from business", Business.class, null);
        return query;
    }

    /**
     * 管理员根据商家编号（id）删除商家数据
     */
    @Override
    public Boolean deleteBusinessById(Integer businessId) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int del = Db.use(ds).del("business", "business_id", businessId);
        return del > 0;
    }
}