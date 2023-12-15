package com.example.pr2up.dao;

import com.example.pr2up.models.ReviewModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewDao {
    private List<ReviewModel> reviews = new ArrayList<>();
    private static int REVIEWS_COUNT;

    public ReviewDao() {
        reviews.add(new ReviewModel(++REVIEWS_COUNT, "Book1", "Author1", 5, "Отличная книга.", LocalDate.now()));
        reviews.add(new ReviewModel(++REVIEWS_COUNT, "Book2", "Author2", 4, "Отличная книга.", LocalDate.now()));
    }

    public ReviewModel get(int id) {

        return reviews.stream().filter(review -> review.getReviewId() == id).findFirst().orElse(null);
    }

    public List<ReviewModel> getAll() {
        return reviews;
    }

    public void save(ReviewModel reviewModel) {
        reviewModel.setReviewId(++REVIEWS_COUNT);
        reviews.add(reviewModel);
    }

    public void update(int id, ReviewModel updatedReview) {
        ReviewModel existingReview = get(id);

        if (existingReview != null) {
            existingReview.setBook(updatedReview.getBook());
            existingReview.setAuthor(updatedReview.getAuthor());
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());
            existingReview.setDate(updatedReview.getDate());
        }
    }

    public void delete(int id) {
        reviews.removeIf(review -> review.getReviewId() == id);
    }
}
