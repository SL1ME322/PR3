package com.example.pr2up.models;

import java.awt.print.Book;
import java.time.LocalDate;

import java.time.LocalDate;

public class ReviewModel {
    private int reviewId;
    private String book;
    private String author;
    private int rating;
    private String comment;
    private LocalDate date;

     public ReviewModel() {

    }

    public ReviewModel(int reviewId, String book, String author, int rating, String comment, LocalDate date) {
        this.reviewId = reviewId;
        this.book = book;
        this.author = author;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    // Геттеры и сеттеры
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
