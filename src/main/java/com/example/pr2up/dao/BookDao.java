package com.example.pr2up.dao;

import com.example.pr2up.models.BookModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookDao implements Dao<BookModel>{
    private List<BookModel> books = new ArrayList<>();
    private static int BOOKS_COUNT;
    public BookDao() {
        books.add(new BookModel(++BOOKS_COUNT,"Ревизор", 1836, "Гоголь", "description"));
        books.add(new BookModel(++BOOKS_COUNT, "Мертвые души", 1836, "Гоголь", "description"));
    }
    @Override
    public BookModel get(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    @Override
    public List<BookModel> getAll() {
        return books;
    }

    @Override
    public void save(BookModel bookModel) {
         bookModel.setId(++BOOKS_COUNT);
         books.add(bookModel);
    }

    @Override
    public void update(int id, BookModel updatedBook) {
        BookModel existingBook = get(id);

        if (existingBook != null) {
            existingBook.setName(updatedBook.getName());
            existingBook.setYear(updatedBook.getYear());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setDescription(updatedBook.getDescription());
        }
    }



    @Override
    public void delete(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
