package poject.elm.service.impl;

import poject.elm.dao.BusinessDao;
import poject.elm.dao.impl.BusinessDaoImpl;
import poject.elm.pojo.Business;
import poject.elm.service.BusinessService;

import java.sql.SQLException;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {

    private static final BusinessDao businessDao = new BusinessDaoImpl();

    /**
     * 商家登录
     */
    @Override
    public Business businessLogin(String businessName, String password) {
        try {
            return businessDao.businessLogin(businessName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 商家注册
     */
    @Override
    public Boolean businessRegister(Business business) {
        try {
            return businessDao.businessRegister(business);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 商家修改个人信息
     */
    @Override
    public Boolean updateBusiness(Business business) {
        try {
            return businessDao.updateBusiness(business);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 管理员查询所有商家信息
     */
    @Override
    public List<Business> businessAll() {
        try {
            return businessDao.businessAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 管理员根据商家编号（id）删除商家数据
     */
    @Override
    public Boolean deleteBusinessById(Integer businessId) {
        try {
            return businessDao.deleteBusinessById(businessId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
