package poject.elm.service;

import poject.elm.pojo.Admin;

/**
 * 管理员业务逻辑层
 */
public interface AdminService {

    /**
     * 管理员登录
     */
    public Admin adminLogin(String adminName, String password);

    /**
     * 管理员修改密码
     */
    public Boolean updatePassword(Integer adminId, String newPassword);
}
