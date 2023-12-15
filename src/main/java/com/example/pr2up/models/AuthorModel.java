package com.example.pr2up.models;

public class AuthorModel {
    public int _id;
    public String _name;
    public String _surname;
    public String _lifeYears;
    public String _country;
    public String _description;
    public AuthorModel(int id, String name, String surname,String lifeYears, String country, String description) {
        _id = id;
        _name = name;
        _surname = surname;
        _lifeYears = lifeYears;
        _country= country;
        _description = description;
    }
    public AuthorModel() {

    }
    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public String getSurname() {
        return _surname;
    }

    public String getLifeYears() {
        return _lifeYears;
    }

    public String getCountry() {
        return _country;
    }

    public String getDescription() {
        return _description;
    }

    // Setter methods
    public void setId(int id) {
        _id = id;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setSurname(String surname) {
        _surname = surname;
    }

    public void setLifeYears(String lifeYears) {
        _lifeYears = lifeYears;
    }

    public void setCountry(String country) {
        _country = country;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
