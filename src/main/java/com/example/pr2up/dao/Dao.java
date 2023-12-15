package com.example.pr2up.dao;

import com.example.pr2up.models.BookModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);



    void update(int id, T t);

    void delete(int id);
}