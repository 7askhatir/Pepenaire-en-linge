package Pepenaire.Dao;

import java.util.List;

public interface Dao<T> {
    //read
    T getById(int id);
    List<T> getAll();
    
    //Create 
    int save(T item);
    int saveAll(List<T> items);
    
    //update
    int update(T item);
    
    //delet
    
    int delet(int id);
    
}