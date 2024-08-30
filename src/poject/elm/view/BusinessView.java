package poject.elm.view;

import cn.hutool.crypto.SecureUtil;
import poject.elm.pojo.Business;
import poject.elm.pojo.Food;
import poject.elm.service.BusinessService;
import poject.elm.service.FoodService;
import poject.elm.service.impl.BusinessServiceImpl;
import poject.elm.service.impl.FoodServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 商家操作界面
 */
public class BusinessView {

    private static final Scanner sc = new Scanner(System.in);
    private static final BusinessService businessService = new BusinessServiceImpl();
    private static final FoodService foodService = new FoodServiceImpl();

    /**
     * 商家登录界面
     */
    public void login() {
        System.out.println("\uD83D\uDD35请输入店名：");
        String businessName = sc.nextLine();
        System.out.println("\uD83D\uDD35请输入密码：");
        String password = sc.nextLine();
        password = SecureUtil.md5(password + businessName);
        Business business = businessService.businessLogin(businessName, password);
        if (business == null) {
            System.out.println("❗ 账号或密码错误 ❗");
        } else {
            System.out.println("欢迎商家！ \uD83D\uDC4F" + business.getBusinessName());
            while (true) {
                System.out.println("\n #\uFE0F⃣请选择操作：\uD83D\uDD341.添加食品  \uD83D\uDD352.查询食品列表  " +
                        "\uD83D\uDFE23.修改食品信息  \uD83D\uDFE44.删除食品  \uD83D\uDFE15.商家修改信息  \uD83D\uDFE06.查询当前商家信息  ❌7.退出");
                String op = sc.nextLine();
                switch (op) {
                    case "1":
                        addFood(business.getBusinessId());
                        break;
                    case "2":
                        foodList(business.getBusinessId());
                        break;
                    case "3":
                        updateFood(business.getBusinessId());
                        break;
                    case "4":
                        deleteFoodById(business.getBusinessId());
                        break;
                    case "5":
                        updateBusiness(business);
                        break;
                    case "6":
                        System.out.println(business);
                        break;
                    case "7":
                        System.out.println("已退出！✔\uFE0F");
                        return;
                    default:
                        System.out.println("❗ 输出错误，请重新选择操作: ❗");
                }
            }
        }
    }

    /**
     * 商家注册界面
     */
    public void register() {
        System.out.println("\uD83D\uDFE2请输入店名：");
        String businessName = sc.nextLine();
        System.out.println("\uD83D\uDFE2请输入密码：");
        String password = sc.nextLine();
        System.out.println("\uD83D\uDFE2请输入地址：");
        String businessAddress = sc.nextLine();
        System.out.println("\uD83D\uDFE2请输入介绍：");
        String businessExplain = sc.nextLine();
        System.out.println("\uD83D\uDFE2请输入起送费：");
        String startPrice = sc.nextLine();
        System.out.println("\uD83D\uDFE2请输入配送费：");
        String deliveryPrice = sc.nextLine();
        Business business = new Business();
        // 再这里对密码进行加密处理
        password = SecureUtil.md5(password + businessName);
        business.setPassword(password);
        business.setBusinessName(businessName);
        business.setBusinessAddress(businessAddress);
        business.setBusinessExplain(businessExplain);
        // 字符串 转 Double
        business.setStartPrice(Double.valueOf(startPrice));
        business.setDeliveryPrice(Double.valueOf(deliveryPrice));
        Boolean b = businessService.businessRegister(business);
        if (b) {
            System.out.println("注册成功！✔\uFE0F");
        } else {
            System.out.println("注册失败！❌");
        }
    }

    /**
     * 商家修改个人信息
     */
    public void updateBusiness(Business business) {
        System.out.println("\uD83D\uDFE6商家的原始数据：" + business);
        System.out.println("\uD83D\uDD35请输入店名：");
        String businessName = sc.nextLine();
        System.out.println("\uD83D\uDD35请输入密码：");
        String password = sc.nextLine();
        System.out.println("\uD83D\uDD35请输入地址：");
        String businessAddress = sc.nextLine();
        System.out.println("\uD83D\uDD35请输入介绍：");
        String businessExplain = sc.nextLine();
        System.out.println("\uD83D\uDD35请输入起送费：");
        String startPrice = sc.nextLine();
        System.out.println("\uD83D\uDD35请输入配送费：");
        String deliveryPrice = sc.nextLine();

        // 再这里对密码进行加密处理
        password = SecureUtil.md5(password + businessName);
        business.setPassword(password);
        business.setBusinessName(businessName);
        business.setBusinessAddress(businessAddress);
        business.setBusinessExplain(businessExplain);
        // 字符串 转 Double
        business.setStartPrice(Double.valueOf(startPrice));
        business.setDeliveryPrice(Double.valueOf(deliveryPrice));
        Boolean b = businessService.updateBusiness(business);
        if (b) {
            System.out.println("修改成功！✔\uFE0F");
        } else {
            System.out.println("修改失败！❌");
        }
    }

    /**
     * 商家添加食品
     */
    public void addFood(Integer businessId) {
        System.out.println("ℹ\uFE0F食品名称");
        String foodName = sc.nextLine();
        System.out.println("ℹ\uFE0F食品介绍");
        String foodExplain = sc.nextLine();
        System.out.println("ℹ\uFE0F食品价格");
        String foodPrice = sc.nextLine();
        System.out.println("ℹ\uFE0F食品状态：1\uFE0F⃣上架   2\uFE0F⃣下架");
        String foodStatus = sc.nextLine();
        System.out.println("ℹ\uFE0F食品库存");
        String foodStock = sc.nextLine();

        Food food = new Food();
        food.setBusinessId(businessId);
        food.setFoodExplain(foodExplain);
        food.setFoodName(foodName);
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setFoodStock(Integer.valueOf(foodStock));

        Boolean b = foodService.addFood(food);
        if (b) {
            System.out.println("添加成功！✔\uFE0F");
        } else {
            System.out.println("添加失败！❌");
        }
    }

    /**
     * 查询商家店铺中的食品列表
     */
    public void foodList(Integer businessId) {
        List<Food> foods = foodService.foodList(businessId);
        foods.forEach(System.out::println);
    }

    /**
     * 商家修改食品信息
     */
    public void updateFood(Integer businessId) {

        System.out.println("\uD83C\uDF71食品列表：");
        new BusinessView().foodList(businessId);

        System.out.println("#\uFE0F⃣请输入修改食物的编号：");
        String foodId = sc.nextLine();

        System.out.println("\uD83C\uDF72请输输入食品名称：");
        String foodName = sc.nextLine();
        System.out.println("\uD83E\uDD57请输输入食品介绍：");
        String foodExplain = sc.nextLine();
        System.out.println("\uD83D\uDCB2请输输入食品价格：");
        String foodPrice = sc.nextLine();
        System.out.println("\uD83C\uDE36请输输入食品状态： 1是上架⬆\uFE0F  2是下架⬇\uFE0F");
        String foodStatus = sc.nextLine();
        System.out.println("\uD83D\uDCE6请输输入食品库存：");
        String foodStock = sc.nextLine();

        Food food = new Food();
        food.setFoodId(Integer.valueOf(foodId));
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodStock(Integer.valueOf(foodStock));

        Boolean b = foodService.updateFood(food);
        if (b) {
            System.out.println("修改成功！✔\uFE0F");
        } else {
            System.out.println("修改失败！❌");
        }
    }

    /**
     * 商家根据食品编号（id）删除食品
     */
    public void deleteFoodById(Integer businessId) {

        System.out.println("\uD83C\uDF71食品列表：");
        new BusinessView().foodList(businessId);

        System.out.println("#\uFE0F⃣请输入删除食物的编号：");
        String foodId = sc.nextLine();

        Boolean b = foodService.deleteFoodById(Integer.valueOf(foodId));
        if (b) {
            System.out.println("删除成功！✔\uFE0F");
        } else {
            System.out.println("删除失败！❌");
        }
    }
}
