package Manager;

import Model.Student;

import java.util.ArrayList;

public class StudentManager implements iManager<Student> {
    ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    @Override
    public ArrayList<Student> showAll() {
        return students;
    }

    @Override
    public void add(Student student) {
         this.students.add(student);
    }

    @Override
    public void removeById(int id) {
        int index = findIndexById(id);
        students.remove(index);
    }

    @Override
    public void update(int id, Student student) {
       int index = findIndexById(id);
       students.set(index, student);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < this.students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Student> findByAgeRange(int minAge, int maxAge) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < this.students.size(); i++) {
            if (students.get(i).getAge() >= minAge && students.get(i).getAge() <= maxAge) {
                students.add(students.get(i));
            }
        }
        return students;
    }
    public ArrayList<Student> findByScoreRange(int minScore, int maxScore) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < this.students.size(); i++) {
            if (students.get(i).getScore() >= minScore && students.get(i).getScore() <= maxScore) {
                students.add(students.get(i));
            }
        }
        return students;
    }

    @Override
    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        for (int i = 0; i < this.students.size(); i++) {
            if (students.get(i).getName().contains(name.toLowerCase())) {
                studentsArrayList.add(students.get(i));
            }
        }
        return studentsArrayList;
    }
}
