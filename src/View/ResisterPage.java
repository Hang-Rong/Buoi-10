package View;


import Security.UserManager;

import java.util.Scanner;

public class ResisterPage {
    static UserManager userManager = new UserManager();
    static Scanner inputString = new Scanner(System.in);
    public static void showResisterPage() {
        Scanner scanner = new Scanner(System.in);

        String userName, password;
        do{
            System.out.print("Nhập tên người dùng: ");
            userName = inputString.nextLine();
            System.out.print("Nhập mật khẩu: ");
            password = inputString.nextLine();
            if(userName.isEmpty()||password.isEmpty()) {
                System.out.println("Tên đăng nhập hoặc mật khẩu không được để trống!");
            }
        }while (userName.isEmpty()||password.isEmpty());
        if (userManager.registerUser(userName, password)) {
            System.out.println("Đăng ký tài khoản thành công!");
            LoginPage.showLoginPage();
        } else {
            System.out.println("Tên người dùng đã tồn tại!");


        }
            scanner.close();
        }
    }

