package poject.elm.view;

import poject.elm.pojo.Admin;
import poject.elm.pojo.Business;
import poject.elm.service.AdminService;
import poject.elm.service.BusinessService;
import poject.elm.service.impl.AdminServiceImpl;
import poject.elm.service.impl.BusinessServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 管理员操作界面
 */
public class AdminView {

    private static final Scanner sc = new Scanner(System.in);
    private static final AdminService adminService = new AdminServiceImpl();
    private static final BusinessService businessService = new BusinessServiceImpl();

    /**
     * 管理员登录
     */
    public void login() {
        System.out.println("\uD83D\uDD34请输入管理员账号：");
        String adminName = sc.nextLine();
        System.out.println("\uD83D\uDD34请输入管理员密码：");
        String password = sc.nextLine();
        Admin admin = adminService.adminLogin(adminName, password);
        if (admin == null) {
            System.out.println("❗ 账号或密码错误 ❗");
        } else {
            System.out.println("欢迎管理员：\uD83D\uDC4F" + admin.getAdminName());
            while (true) {
                System.out.println("\n #\uFE0F⃣请选择操作：\uD83D\uDD341.查询所有商家  \uD83D\uDD352.删除商家  \uD83D\uDFE23.修改密码  ❌4.退出");
                String op = sc.nextLine();
                switch (op) {
                    case "1":
                        printBusinessAll();
                        break;
                    case "2":
                        deleteBusinessById();
                        break;
                    case "3":
                        updatePassword(admin);
                        break;
                    case "4":
                        System.out.println("已退出！✔\uFE0F");
                        return;
                    default:
                        System.out.println("❗ 输入错误 ❗");
                }
            }
        }
    }


    /**
     * 管理员查询所有商家信息
     */
    public void printBusinessAll() {
        List<Business> businesses = businessService.businessAll();
        businesses.forEach(System.out::println);
    }

    /**
     * 管理员根据商家编号（id）删除商家数据
     */
    public void deleteBusinessById() {
        System.out.println("⚠\uFE0F确定要删除吗？ Y / N");
        String yn = sc.nextLine();
        if ("Y".equalsIgnoreCase(yn)) {
            System.out.println("#\uFE0F⃣请输入商家的编号：");
            String businessId = sc.nextLine();
            Boolean b = businessService.deleteBusinessById(Integer.valueOf(businessId));
            if (b) {
                System.out.println("删除成功！✔\uFE0F");
            } else {
                System.out.println("删除失败！❌");
            }
        }
    }

    /**
     * 管理员修改密码
     */
    public void updatePassword(Admin admin) {
        System.out.println("#\uFE0F⃣请输入旧密码");
        String oldPassword = sc.nextLine();
        System.out.println("\uD83C\uDD95请输入新密码");
        String newPassword = sc.nextLine();
        System.out.println("\uD83C\uDD95请确认新密码");
        String confirmPassword = sc.nextLine();
        // 旧密码输入正确
        if (oldPassword.equals(admin.getPassword())) {
            // 新密码和确认新密码输入一致
            if (newPassword.equals(confirmPassword)) {
                if (newPassword.equals(oldPassword)) {
                    System.out.println("❗ 输入的新密码与旧密码相同，请重新输入 ❗");
                } else {
                    Boolean b = adminService.updatePassword(admin.getAdminId(), newPassword);
                    if (b) {
                        System.out.println("密码修改成功 ✔\uFE0F");
                    } else {
                        System.out.println("密码修改失败 ❌");
                    }
                }
            } else {
                System.out.println("❗ 输入的新密码不一致，请重新输入 ❗");
            }
        } else {
            System.out.println("❗ 输入的旧密码和原始密码不一致，请重新输入 ❗");
        }
    }

}

