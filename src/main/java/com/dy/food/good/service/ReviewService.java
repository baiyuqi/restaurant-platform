package com.dy.food.good.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dy.food.account.service.UserService;
import com.dy.food.good.model.Review;
import com.dy.food.good.repository.ReviewRepository;
import com.dy.food.good.service.GoodService;
import com.dy.food.good.service.ReviewService;
import com.dy.food.good.web.CreateOrUpdateReviewRequest;
import com.dy.food.good.web.GoodResponse;

import static com.dy.food.commons.util.CommonUtilityMethods.getUserIdFromToken;
import static com.dy.food.commons.util.CommonUtilityMethods.getUserNameFromToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Yuqi.Bai, Date : 08-Nov-2020
 */
@Service
public class  ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserService accountFeignClient;

    @Autowired
    GoodService goodService;

   
    public void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = getUserIdFromToken(authentication);
        String userNameFromToken = getUserNameFromToken(authentication);

        //check whether good exists.
        GoodResponse good = goodService.getGood(createOrUpdateReviewRequest.getGoodId());
        if (good == null) {
            throw new RuntimeException("Good doesn't exist!");
        }

        Optional<Review> review = reviewRepository.findByUserIdAndGoodId(userIdFromToken, createOrUpdateReviewRequest.getGoodId());

        if (review.isPresent()) {
            Review updatedReview = review.get();
            updatedReview.setRatingValue(createOrUpdateReviewRequest.getRatingValue());
            updatedReview.setReviewMessage(createOrUpdateReviewRequest.getReviewMessage());
            reviewRepository.save(updatedReview);
        } else {
            Review newReview = Review.builder()
                    .reviewMessage(createOrUpdateReviewRequest.getReviewMessage())
                    .ratingValue(createOrUpdateReviewRequest.getRatingValue())
                    .userId(userIdFromToken)
                    .userName(userNameFromToken)
                    .goodId(createOrUpdateReviewRequest.getGoodId())
                    .build();
            reviewRepository.save(newReview);
        }
    }

   
    public List<Review> getReviewsForGood(String goodId) {

        Optional<List<Review>> reviewsForGood = reviewRepository.findAllByGoodId(goodId);
        return reviewsForGood.orElseGet(ArrayList::new);

    }
}
