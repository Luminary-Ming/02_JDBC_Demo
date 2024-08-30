package poject.elm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import poject.elm.dao.FoodDao;
import poject.elm.pojo.Food;
import poject.elm.util.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    /**
     * 添加食品
     */
    @Override
    public Boolean addFood(Food food) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).execute("insert into food values(null, ?, ?, ?, ?, ?, ?)",
                food.getFoodName(), food.getFoodExplain(), food.getFoodPrice(),
                food.getBusinessId(), food.getFoodStatus(), food.getFoodStatus()
        );
        return i > 0;
    }

    /**
     * 查询食品列表信息
     */
    @Override
    public List<Food> foodList(Integer businessId) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        return Db.use(ds).query("select * from food where business_id = ?", Food.class, businessId);
    }

    /**
     * 修改食品信息
     */
    @Override
    public Boolean updateFood(Food food) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        int i = Db.use(ds).update(
                Entity.create().set("food_name", food.getFoodName()).set("food_explain", food.getFoodExplain())
                        .set("food_price", food.getFoodPrice()).set("food_status", food.getFoodStatus())
                        .set("food_stock", food.getFoodStock()),
                Entity.create("food").set("food_id", food.getFoodId())
        );
        return i > 0;
    }

    /**
     * 商家根据食品编号（id）删除食品
     */
    @Override
    public Boolean deleteFoodById(Integer foodId) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from food where food_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, foodId);
        int i = stmt.executeUpdate();
        return i > 0;
    }
}
