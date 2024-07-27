package View;

import java.util.Scanner;

public class HomePage {
    public static void showHomePage() {
    StudentMenu studentMenu = new StudentMenu();
    SchoolMenu schoolMenu = new SchoolMenu();
    Scanner inputNumber = new Scanner(System.in);
    int choice;
    do {
        System.out.println("===== Homepage ====== \n" +
                "1. To student management menu\n" +
                "2. To school management menu\n" +
                "0. End session");
        System.out.println("Choose your choice: ");
        choice = inputNumber.nextInt();
        switch (choice) {
            case 1:
                StudentMenu.showStudentMenu();
                break;
            case 2:
                SchoolMenu.showSchoolManagerMenu();
                break;
            case 0:
                System.out.println("Session ended");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    } while (choice != 0);

}
}
