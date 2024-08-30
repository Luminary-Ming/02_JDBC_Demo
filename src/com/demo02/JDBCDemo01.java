package com.demo02;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * 演示 sql 的预处理，防止 sql 注入
 *
 * SQL 注入是：
 * 例：假设在一个登录界面中，账号和密码是界面需要输入的数据，输入的内容最终与 sql 语句拼接在一起，
 * 组合一个完整的 sql 语句，根据这条语句到数据库中查询当前用户的个人信息。
 * 而存在有意图者通过输入框加入一些 sql 关键字或条件，或其他内容，最终目标是改变 sql 的执行逻辑，
 * 到达欺骗服务器执行恶意的 sql 命令。
 *
 * 预防：
 * 可以将需要拼接的数据预留出来，先用占位符替代，将需要执行的SQL语句先提前处理。
 * 然后对于占位符的数据，在执行 sql 的时候，只是会当作普通数据处理，而不会当作 sql 脚本。
 * 即使这些数据中添加了 sql 脚本也不会执行。
 */
public class JDBCDemo01 {

    /**
     * 插入数据，制造异常，通过事务控制数据回滚
     */
    @Test
    public void testInsert() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        // 设置手动提交事务
        conn.setAutoCommit(false);
        PreparedStatement stmt = null;
        Savepoint sp = null;
        try {
            for (int i = 1; i <= 10; i++) {
                String sql = "insert into users values(null, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "无双剑姬" + i);
                stmt.setString(2, "wsjj" + i);
                stmt.setString(3, "艾欧尼亚" + i);
                stmt.executeUpdate();
                if (i % 1000 == 0) {
                    conn.commit();
                    // 先释放前面的回滚点
                    conn.releaseSavepoint(sp);
                    sp = conn.setSavepoint();
                }
            }
            conn.commit();
        } catch (ArithmeticException e) {
            conn.rollback(sp);
        } finally {
            JDBCUtils.close(conn, stmt);
        }
    }

    /**
     * 演示手动提交事务
     */
    @Test
    public void testDelete() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        // 在获取到数据库之后，必须先设置事务相关操作，再使用链接去操作数据库
        conn.setAutoCommit(false);
        String sql = "delete from users where id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, 6);
        int i = stmt.executeUpdate();
        System.out.println(i);
        conn.commit();
        JDBCUtils.close(conn, stmt);
    }

    @Test
    public void testSelect() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from users where username =? and password = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        // 需要设置参数
        stmt.setString(1, "诺克萨斯之手");
        stmt.setString(2, "nksszs");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
            System.out.println(rs.getString("address"));
        }
        JDBCUtils.close(conn, stmt, rs);
    }
}
