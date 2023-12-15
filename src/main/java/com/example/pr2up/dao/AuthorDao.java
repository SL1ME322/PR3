package com.example.pr2up.dao;

import com.example.pr2up.models.AuthorModel;
import com.example.pr2up.models.BookModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AuthorDao implements Dao<AuthorModel> {
    private static int AUTHOR_COUNT;
    private List<AuthorModel> authors = new ArrayList<>();
    public AuthorDao() {
        authors.add(new AuthorModel(++AUTHOR_COUNT,"Александр Сергеевич","Пушкин ", "1799-1837","Россия","Крут"));
        authors.add(new AuthorModel(++AUTHOR_COUNT,"Федор Михайлович","Достое́вский ", "1821-1881","Россия","Крут"));
    }

    @Override
    public AuthorModel get(int id) {
        return authors.stream().filter(authorModel -> authorModel.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<AuthorModel> getAll() {
        return authors;
    }

    @Override
    public void save(AuthorModel authorModel) {
        authorModel.setId(++AUTHOR_COUNT);
        authors.add(authorModel);
    }

    @Override
    public void update(int id, AuthorModel authorModel) {
        AuthorModel existingBook = get(id);

        if (existingBook != null) {
            existingBook.setName(authorModel.getName());
            existingBook.setSurname(authorModel.getSurname());
            existingBook.setLifeYears(authorModel.getLifeYears());
            existingBook.setCountry(authorModel.getCountry());
            existingBook.setDescription(authorModel.getDescription());
        }
    }

    @Override
    public void delete(int id) {
        authors.removeIf(book -> book.getId() == id);
    }
}
