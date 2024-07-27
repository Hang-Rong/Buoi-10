package Manager;

import Model.School;

import java.util.ArrayList;

public class SchoolManager implements iManager<School> {
    ArrayList<School> schools = new ArrayList<>();

    public SchoolManager() {
        this.schools = new ArrayList<>();
    }
    public void addSchool(School s) {}

    @Override
    public ArrayList<School> showAll() {
        return schools;
    }

    @Override
    public void add(School school) {
        schools.add(school);
    }

    @Override
    public void removeById(int id) {
        for (int i = 0; i < schools.size(); i++) {
            if (schools.get(i).getId() == id) {
                schools.remove(i);
            }
        }
    }

    @Override
    public void update(int id, School school) {
         for (int i = 0; i < schools.size(); i++) {
             if (schools.get(i).getId() == id) {
                 schools.set(i, school);
             }
         }
    }

    @Override
    public int findIndexById(int id) {
         for (int i = 0; i < schools.size(); i++) {
             if (schools.get(i).getId() == id) {
                 return i;
             }
         }
         return -1;
    }

    @Override
    public ArrayList<School> findByName(String name) {
        ArrayList<School> schoolArrayList = new ArrayList<>();
        for (School school : schools) {
            if (school.getName().toLowerCase().contains(name.toLowerCase())) {
                schoolArrayList.add(school);
            }
        }
        return schoolArrayList;
    }

}
