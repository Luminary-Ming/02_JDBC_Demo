package poject.elm.dao;

import poject.elm.pojo.Business;

import java.sql.SQLException;
import java.util.List;

/**
 * 商家表数据库访问层
 */
public interface BusinessDao {

    /**
     * 商家登录
     */
    public Business businessLogin(String businessName,String password) throws SQLException;

    /**
     * 商家注册
     */
    public Boolean businessRegister(Business business) throws SQLException;

    /**
     * 商家修改个人信息
     */
    public Boolean updateBusiness(Business business) throws SQLException;

    /**
     *  管理员查询所有商家信息
     */
    public List<Business> businessAll() throws SQLException;

    /**
     * 管理员根据商家编号（id）删除商家数据
     */
    public Boolean deleteBusinessById(Integer businessId) throws SQLException;

}
