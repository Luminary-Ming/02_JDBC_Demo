package poject.elm.service;

import poject.elm.pojo.Food;

import java.util.List;

/**
 * 食品业务逻辑层
 */
public interface FoodService {

    /**
     * 添加食品
     */
    public Boolean addFood(Food food);

    /**
     * 查询食品列表信息
     */
    public List<Food> foodList(Integer businessId);

    /**
     * 修改食品信息
     */
    public Boolean updateFood(Food food);

    /**
     * 商家根据食品编号（id）删除食品
     */
    public Boolean deleteFoodById(Integer foodId);
}
