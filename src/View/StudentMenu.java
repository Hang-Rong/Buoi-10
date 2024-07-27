package View;

import Manager.StudentManager;
import Model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class StudentMenu {
    static Manager.StudentManager StudentManager = new StudentManager();

    static Scanner inputInt = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);

    public static void showStudentMenu() {
        int choice;
        do {
            System.out.println("===== Student manager menu ===== \n" +
                    "1. Add student \n" +
                    "2. Update student information \n" +
                    "3. Discard unused information \n" +
                    "4. Search by approximate name \n" +
                    "5. Display list of students by score range \n" +
                    "6. Search by age range \n" +
                    "7. Display list of students \n" +
                    "0. Return to main menu");
            System.out.println("Enter your choice: ");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showStudentAddMenu();
                    break;
                case 2:
                    showStudentUpdateMenu();
                    break;
                case 3:
                    showDiscardStudentMenu();
                    break;
                case 5:
                    showStudentByScoreRange();
                    break;
                case 4:
                    showSearchStudentByNameMenu();
                    break;
                case 6:
                    showSearchByAgeRangeMenu();
                    break;
                case 7:
                    showAllStudents();
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }

    private static void showStudentByScoreRange() {
        System.out.println("Enter student score range");
        System.out.println("Min score: ");
        double minScore = inputString.nextDouble();
        System.out.println("Max score: ");
        double maxScore = inputString.nextDouble();
        ArrayList<Student> students = StudentManager.findByScoreRange((int) minScore, (int) maxScore);
        if (students.isEmpty()){
            System.out.println("No students found");
        } else {
            System.out.println("Found: ");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void showStudentAddMenu() {
        System.out.println("===== Student add menu =====");
        System.out.println("Enter student name: ");
        String name = inputString.nextLine();
        System.out.println("Enter student age: ");
        int age = inputInt.nextInt();
        System.out.println("Enter student gender: ");
        String gender = inputString.nextLine();
        System.out.println("Enter student score: ");
        double score = inputInt.nextDouble();
        Student student = new Student(name, age, gender, score);
        StudentManager.add(student);
        System.out.println("===== Student added =====");
    }

    private static void showStudentUpdateMenu() {
        int updateInformationId;
        System.out.println("===== Student update menu =====");
        do {
            System.out.println("Enter student ID: ");
            updateInformationId = inputInt.nextInt();
            if (StudentManager.findIndexById(updateInformationId) == -1) {
                System.out.println("Id not found");
            }
        } while (StudentManager.findIndexById(updateInformationId) == -1);
        System.out.println("Enter student name: ");
        String studentName = inputString.nextLine();
        System.out.println("Enter student age: ");
        int studentAge = inputInt.nextInt();
        System.out.println("Enter student gender: ");
        String studentGender = inputString.nextLine();
        System.out.println("Enter student score: ");
        double studentScore = inputString.nextDouble();

        Student newstudent = new Student(studentName, studentAge, studentGender, studentScore);
        StudentManager.update(updateInformationId, newstudent);
        System.out.println("== Updated student information successfully ==");
    }


    private static void showDiscardStudentMenu() {
        int idDiscardStudent;

        System.out.println("===== Discard student menu ===== ");
        System.out.println("Enter student id: ");
        idDiscardStudent = inputInt.nextInt();
        if (StudentManager.findIndexById(idDiscardStudent) == -1) {
            System.out.println("Student not found");
        } else {
            StudentManager.removeById(idDiscardStudent);
        }
    }

    private static void showSearchStudentByNameMenu() {
        System.out.println("====== Search student by name menu =======");
        System.out.println("Enter student name: ");
        String name = inputString.nextLine();
        ArrayList<Student> students = StudentManager.findByName(name);
        if (students.isEmpty()) {
            System.out.println("Student not found");
        } else {
            System.out.println("Student found");
            System.out.println(students);
        }
    }

    private static void showSearchByAgeRangeMenu() {
        System.out.println("====== Search student by age range menu =======");
        System.out.println("Enter range");
        System.out.println("Min age: ");
        int minAge = inputInt.nextInt();
        System.out.println("Max age: ");
        int maxAge = inputInt.nextInt();
        ArrayList<Student> studentsList = StudentManager.findByAgeRange(Integer.parseInt(String.valueOf(minAge)), Integer.parseInt(String.valueOf(maxAge)));
        if (studentsList.isEmpty()) {
            System.out.println("Student not found");
        } else {
            System.out.println("===== Result =====");
            for (Student students : studentsList) ;
            System.out.println(studentsList);
        }
    }

    private static void showAllStudents() {
        System.out.println("==== Student List ====");
        ArrayList<Student> studentsList;
        studentsList = StudentManager.showAll();
        for (Student students : studentsList) {
            System.out.println(students);
        }
    }
}
