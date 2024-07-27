package Manager;

import java.util.ArrayList;

public interface iManager<E> {
    ArrayList<E> showAll();
    void add(E e);
    void removeById(int id);
    void update(int id,E e);
    int findIndexById(int id);
    ArrayList<E> findByName(String name);



}
