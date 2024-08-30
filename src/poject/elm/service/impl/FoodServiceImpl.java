package poject.elm.service.impl;

import poject.elm.dao.FoodDao;
import poject.elm.dao.impl.FoodDaoImpl;
import poject.elm.pojo.Food;
import poject.elm.service.FoodService;

import java.sql.SQLException;
import java.util.List;

public class FoodServiceImpl implements FoodService {

    private static final FoodDao foodDao = new FoodDaoImpl();

    /**
     * 添加食品
     */
    @Override
    public Boolean addFood(Food food) {
        try {
            return foodDao.addFood(food);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询食品列表信息
     */
    @Override
    public List<Food> foodList(Integer businessId) {
        try {
            return foodDao.foodList(businessId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改食品信息
     */
    @Override
    public Boolean updateFood(Food food) {
        try {
            return foodDao.updateFood(food);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 商家根据食品编号（id）删除食品
     */
    @Override
    public Boolean deleteFoodById(Integer foodId) {
        try {
            return foodDao.deleteFoodById(foodId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
