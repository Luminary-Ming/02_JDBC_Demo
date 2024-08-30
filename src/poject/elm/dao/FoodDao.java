package poject.elm.dao;

import poject.elm.pojo.Food;

import java.sql.SQLException;
import java.util.List;

/**
 * 食品表数据库访问层
 */
public interface FoodDao {

    /**
     * 添加食品
     */
    public Boolean addFood(Food food) throws SQLException;

    /**
     * 查询食品列表信息
     */
    public List<Food> foodList(Integer businessId) throws SQLException;

    /**
     * 修改食品信息
     */
    public Boolean updateFood(Food food) throws SQLException;

    /**
     * 商家根据食品编号（id）删除食品
     */
    public Boolean deleteFoodById(Integer foodId) throws SQLException;

}
