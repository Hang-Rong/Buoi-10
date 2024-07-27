package View;

import Security.UserManager;

import java.util.Scanner;

public class LoginPage {
    static UserManager userManager = new UserManager();
    static Scanner inputString = new Scanner(System.in);

    public static void showLoginPage() {
        System.out.println("=====Đăng nhập=====");
        if (userManager.getAll().isEmpty()) {
            System.out.println("Hiện không có tài khoản!");
            return;
        }
        System.out.print("Nhập tên người dùng: ");
        String userName = inputString.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = inputString.nextLine();
        if (userManager.getLoginCredentials(userName, password)) {
            System.out.println("Login successful");
            System.out.println("Welcome: " + userName);
            HomePage.showHomePage();
        } else {
            System.out.println("Wrong password or username, try again!");
        }
    }
}


