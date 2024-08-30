package poject.elm;

import poject.elm.view.AdminView;
import poject.elm.view.BusinessView;

import java.util.Scanner;

public class ElmApp {

    private static final BusinessView businessView = new BusinessView();
    private static final AdminView adminView = new AdminView();

    public static void main(String[] args) {
        System.out.println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89欢迎使用饿了么外卖系统\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择登录方式：⬇\uFE0F");
            System.out.println("\n #\uFE0F⃣请选择操作：\uD83D\uDD341.管理员登录  \uD83D\uDD352.商家登录  \uD83D\uDFE23.商家注册  ❌4.退出");
            String op = sc.nextLine();
            switch (op) {
                case "1":
                    adminView.login();
                    break;
                case "2":
                    businessView.login();
                    break;
                case "3":
                    businessView.register();
                    break;
                case "4":
                    System.out.println("已退出！✔\uFE0F");
                    return;
                default:
                    System.out.println("❗ 输出错误，请重新选择登录方式 ❗");
                    break;
            }
        }
    }
}
