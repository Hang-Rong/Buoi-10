package Model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double score;
    private static int idIncrement = 10100;
    public Student(String name, int age, String gender, double score) {
        this.id = idIncrement++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score= score;
    }

    public Student(int id, String name, int age, String gender, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Student.idIncrement = idIncrement;
    }
    @Override
    public String toString() {
        return "Id: "+id+" , Full name: "+ name+" , Gender: "+gender+" , Age: "+age+" , Score: "+ score;
    }

}
