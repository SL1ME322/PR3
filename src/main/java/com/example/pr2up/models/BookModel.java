package com.example.pr2up.models;

public class BookModel {

    public int _id;
    public String _name;
    public int _year;
    public String _author;
    public String _description;
    public BookModel( int id, String name, int year, String author, String description) {
        _id = id;
        _name = name;
        _year = year;
        _author = author;
        _description = description;
    }
    public BookModel( ) {

    }
    public String getName() {
        return _name;
    }

    public void setName(String name) {
         _name = name;
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        _year = year;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }
}
