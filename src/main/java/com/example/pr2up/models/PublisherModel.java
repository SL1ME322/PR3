package com.example.pr2up.models;

public class PublisherModel {
    private int publisherId;
    private String name;
    private String address;
    private String phoneNumber;
    private String website;


    public PublisherModel() {

    }

    public PublisherModel(int publisherId, String name, String address, String phoneNumber, String website) {
        this.publisherId = publisherId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    // Геттеры и сеттеры
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
