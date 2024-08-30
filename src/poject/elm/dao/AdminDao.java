package poject.elm.dao;

import poject.elm.pojo.Admin;

import java.sql.SQLException;

/**
 * 管理员表数据库访问层
 */
public interface AdminDao {

    /**
     * 管理员登录
     */
    public Admin adminLogin(String adminName, String password) throws SQLException;

    /**
     * 管理员修改密码
     */
    public Boolean updatePassword(Integer adminId, String newPassword) throws SQLException;
}
