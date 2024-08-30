package poject.elm.pojo;

/**
 * 管理员类
 */
public class Admin {
    private Integer adminId;
    private String adminName;
    private String password;

    @Override
    public String toString() {
        return "管理员信息➡\uFE0F " +
                "\uD83C\uDD94管理员id：" + adminId +
                ", #\uFE0F⃣管理员姓名：'" + adminName + '\'' +
                ", *\uFE0F⃣管理员密码：'" + password + '\'' +
                " ⬅\uFE0F";
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
