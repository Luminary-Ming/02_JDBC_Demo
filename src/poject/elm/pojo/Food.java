package poject.elm.pojo;

/**
 * 食品类
 */
public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer businessId;
    private Integer foodStatus;
    private Integer foodStock;

    @Override
    public String toString() {
        return "Food➡\uFE0F " +
                "\uD83C\uDD94食品编号=" + foodId +
                ", \uD83C\uDF72食物名称：'" + foodName + '\'' +
                ", \uD83E\uDD57食物介绍：'" + foodExplain + '\'' +
                ", \uD83D\uDCB2食物价格：" + foodPrice +
                ", \uD83C\uDFEC商家店名：" + businessId +
                ", \uD83C\uDE36食品状态：" + (foodStatus == 1 ? "上架⬆\uFE0F" : "下架⬇\uFE0F") +
                ", \uD83D\uDCE6食品库存：" + foodStock +
                " ⬅\uFE0F";
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(Integer foodStatus) {
        this.foodStatus = foodStatus;
    }

    public Integer getFoodStock() {
        return foodStock;
    }

    public void setFoodStock(Integer foodStock) {
        this.foodStock = foodStock;
    }
}
