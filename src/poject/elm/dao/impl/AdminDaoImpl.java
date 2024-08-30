package poject.elm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import poject.elm.dao.AdminDao;
import poject.elm.pojo.Admin;
import poject.elm.util.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    /**
     * 管理员登录
     */
    @Override
    public Admin adminLogin(String adminName, String password) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from admin where admin_name = ? and password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, adminName);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Admin admin = new Admin();
            admin.setAdminId(rs.getInt("admin_id"));
            admin.setAdminName(rs.getString("admin_name"));
            admin.setPassword(rs.getString("password"));
            return admin;
        }
        return null;
    }

    /**
     * 管理员修改密码
     */
    @Override
    public Boolean updatePassword(Integer adminId, String newPassword) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).update(
                Entity.create().set("password", newPassword),
                Entity.create("admin").set("admin_id", adminId)
        );
        return i > 0;
    }
}

class AdminDaoImplText extends AdminDaoImpl{

}
