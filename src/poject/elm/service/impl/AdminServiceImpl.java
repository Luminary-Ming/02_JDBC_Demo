package poject.elm.service.impl;

import poject.elm.dao.AdminDao;
import poject.elm.dao.impl.AdminDaoImpl;
import poject.elm.pojo.Admin;
import poject.elm.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {

    private static final AdminDao adminDao = new AdminDaoImpl();

    /**
     * 管理员登录
     */
    @Override
    public Admin adminLogin(String adminName, String password) {
        try {
            return adminDao.adminLogin(adminName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 管理员修改密码
     */
    @Override
    public Boolean updatePassword(Integer adminId, String newPassword) {
        try {
            return adminDao.updatePassword(adminId,newPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
