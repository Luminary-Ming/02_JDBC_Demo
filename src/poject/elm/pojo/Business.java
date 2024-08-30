package poject.elm.pojo;

/**
 * 商家类
 */
public class Business {
    private Integer businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double startPrice;
    private Double deliveryPrice;

    @Override
    public String toString() {
        return "商家信息➡\uFE0F " +
                "\uD83C\uDD94商家编号：" + businessId +
                ", *\uFE0F⃣商家密码：'" + password + '\'' +
                ", \uD83C\uDFEC商家店名：'" + businessName + '\'' +
                ", \uD83D\uDEA9商家地址：'" + businessAddress + '\'' +
                ", \uD83C\uDF69商家介绍：'" + businessExplain + '\'' +
                ", \uD83D\uDCB2起送费：" + startPrice +
                ", \uD83D\uDCB2配送费：" + deliveryPrice +
                " ⬅\uFE0F";
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }
}
