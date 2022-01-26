package dev.lee.repositories;


import dev.lee.models.User;

import java.util.List;

public interface GenericDAO<T> {

    //Create
    //T add(T t);

    //Read
   // T getByID(Integer id);

    //List<T> getAll();

    //Update
    void update(T t);

    void update(User user);

    //Delete
    void delete(Integer id);

}