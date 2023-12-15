package com.example.pr2up;

import com.example.pr2up.dao.ReviewDao;
import com.example.pr2up.models.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.pr2up.dao.ReviewDao;
import com.example.pr2up.models.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class ReviewController {

    private final ReviewDao reviewDao;

    @Autowired
    public ReviewController(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @PatchMapping("/reviews/{reviewId}")
    public String updateReview(@ModelAttribute("review") ReviewModel review, @PathVariable("reviewId") int reviewId) {
        reviewDao.update(reviewId, review);
        return "redirect:/books";
    }

    @GetMapping("/reviews/{reviewId}/reviewEdit")
    public String reviewEdit(Model model, @PathVariable("reviewId") int reviewId) {
        model.addAttribute("review", reviewDao.get(reviewId));
        return "books/reviewEdit";
    }

    @GetMapping("/reviews/{reviewId}")
    public String showReview(@PathVariable("reviewId") int reviewId, Model model) {
        model.addAttribute("review", reviewDao.get(reviewId));
        return "books/showReview";
    }

    @PostMapping("/createReview")
    public String createReview(@ModelAttribute("review") ReviewModel review) {
        reviewDao.save(review);
        return "redirect:/books";
    }

    @DeleteMapping("/review/{id}")
    public String deleteReview(@PathVariable("id") int id) {
        reviewDao.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/newReview")
    public String newReview(@ModelAttribute("review") ReviewModel review) {
        return "books/newReview";
    }
}
