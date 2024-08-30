package poject.elm.service;

import poject.elm.pojo.Business;

import java.util.List;

/**
 * 商家业务逻辑层
 */
public interface BusinessService {

    /**
     * 商家登录
     */
    public Business businessLogin(String businessName, String password);

    /**
     * 商家注册
     */
    public Boolean businessRegister(Business business);

    /**
     * 商家修改个人信息
     */
    public Boolean updateBusiness(Business business);

    /**
     * 管理员查询所有商家信息
     */
    public List<Business> businessAll();

    /**
     * 管理员根据商家编号（id）删除商家数据
     */
    public Boolean deleteBusinessById(Integer businessId);
}
