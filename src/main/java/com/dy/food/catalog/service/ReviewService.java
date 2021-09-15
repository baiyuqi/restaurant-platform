package com.dy.food.catalog.service;

import java.util.List;

import com.dy.food.catalog.repository.dao.Review;
import com.dy.food.catalog.web.CreateOrUpdateReviewRequest;

/**
 * @author Yuqi.Bai, Date : 08-Nov-2020
 */
public interface ReviewService {

    void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest);

    List<Review> getReviewsForProduct(String productId);

}
