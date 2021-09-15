package com.dy.restaurant.catalog.service;

import java.util.List;

import com.dy.restaurant.catalog.repository.dao.Review;
import com.dy.restaurant.catalog.web.CreateOrUpdateReviewRequest;

/**
 * @author Yuqi.Bai, Date : 08-Nov-2020
 */
public interface ReviewService {

    void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest);

    List<Review> getReviewsForProduct(String productId);

}
