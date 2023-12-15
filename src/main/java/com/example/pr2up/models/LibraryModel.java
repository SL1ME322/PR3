package com.example.pr2up.models;

public class LibraryModel {
    private int libraryId;
    private String name;
    private String address;
    private String librarian;
    private int capacity;
    private String openingHours;


    public LibraryModel() {

    }

    public LibraryModel(int libraryId, String name, String address, String librarian, int capacity, String openingHours) {
        this.libraryId = libraryId;
        this.name = name;
        this.address = address;
        this.librarian = librarian;
        this.capacity = capacity;
        this.openingHours = openingHours;
    }

    // Геттеры и сеттеры
    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLibrarian() {
        return librarian;
    }

    public void setLibrarian(String librarian) {
        this.librarian = librarian;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}
