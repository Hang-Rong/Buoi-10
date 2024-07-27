import View.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ResisterPage resisterPage = new ResisterPage();
        LoginPage loginPage = new LoginPage();
        Scanner inputNumber = new Scanner(System.in);
        int choice = -1;
        do {
                System.out.println("===== Welcome ====== \n" +
                        "1. To login exited account\n" +
                        "2. To register account\n" +
                        "0. End session");
                System.out.println("Choose your choice: ");
                if (inputNumber.hasNextInt()) {
                    choice = inputNumber.nextInt();
                } else {
                    inputNumber.next();
                    System.out.println("Invalid choice. Please enter a number.");
                    continue;
                }
                switch (choice) {
                    case 1:
                        loginPage.showLoginPage();
                        break;
                    case 2:
                        resisterPage.showResisterPage();
                        break;
                    case 0:
                        System.out.println("Session ended");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
        } while (choice != 0) ;

            if (inputNumber != null) {
                inputNumber.close();
            }
        }
    }
