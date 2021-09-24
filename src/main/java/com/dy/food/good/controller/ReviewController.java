package com.dy.food.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dy.food.good.repository.dao.Review;
import com.dy.food.good.service.ReviewService;
import com.dy.food.good.web.CreateOrUpdateReviewRequest;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Yuqi.Bai, Date : 08-Nov-2020
 */
@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<?> createOrUpdateReview(@RequestBody @Valid CreateOrUpdateReviewRequest createOrUpdateReviewRequest) {

        reviewService.createOrUpdateReview(createOrUpdateReviewRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/review")
    public ResponseEntity<?> getAllReviewsForGood(@RequestParam("goodId") String goodId) {
        List<Review> reviewsForGood = reviewService.getReviewsForGood(goodId);
        return ResponseEntity.ok(reviewsForGood);
    }
}
