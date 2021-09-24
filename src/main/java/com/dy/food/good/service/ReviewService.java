package com.dy.food.good.service;

import java.util.List;

import com.dy.food.good.repository.dao.Review;
import com.dy.food.good.web.CreateOrUpdateReviewRequest;

/**
 * @author Yuqi.Bai, Date : 08-Nov-2020
 */
public interface ReviewService {

    void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest);

    List<Review> getReviewsForGood(String goodId);

}
