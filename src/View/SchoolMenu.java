package View;


import Model.School;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolMenu {
    static Manager.SchoolManager SchoolManager = new Manager.SchoolManager();

    static Scanner inputInt = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);

    public static void showSchoolManagerMenu() {
        int choice;
        do {
            System.out.println("======= School management menu ========\n" +
                    "1. Add new school\n" +
                    "2. Discard school\n" +
                    "3. Search by approximate name\n" +
                    "4. Show all available school\n" +
                    "0. Return to main menu");
            System.out.println("Enter your choice: ");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showSchoolAddMenu();
                    break;
                case 2:
                    showDiscardSchoolMenu();
                    break;
                case 3:
                    showSearchBySchoolNameMenu();
                    break;
                case 4:
                    showAvailableSchool();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
    }

    private static void showAvailableSchool() {
        System.out.println("====== Available school ======");
        ArrayList<School> schoolArrayList = SchoolManager.showAll();
        for (School school : schoolArrayList) {
            System.out.println(school);
        }
    }

    private static void showSchoolAddMenu() {
        System.out.println("======= Add new school =======");
        System.out.println("Enter school name: ");
        String schoolName = inputString.nextLine();
        System.out.println("Enter school address: ");
        String schoolAddress = inputString.nextLine();
        School newSchool = new School(schoolName, schoolAddress);
        SchoolManager.addSchool(newSchool);
        System.out.println("School added successfully");
    }

    private static void showDiscardSchoolMenu() {
        System.out.println("======= Discard school management menu ========");
        System.out.println("Enter school id: ");
        int schoolId = inputInt.nextInt();
        SchoolManager.removeById(schoolId);
        System.out.println("Successfully discarded school");
    }

    private static void showSearchBySchoolNameMenu() {
        System.out.println("Enter school name: ");
        String schoolName = inputString.nextLine();
        ArrayList<School> schoolsList = SchoolManager.findByName(schoolName);
        if (schoolsList.isEmpty()) {
            System.out.println("School not found");
        } else {
            System.out.println("Found " + schoolName);
            for (School school : schoolsList) {
                System.out.println(school);
            }
        }
    }

}
