package com.dy.restaurant.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.restaurant.catalog.repository.dao.Review;

import java.util.List;
import java.util.Optional;

/**
 * @author Yuqi.Bai, Date : 07-Nov-2020
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    Optional<Review> findByUserIdAndProductId(String userId, String productId);

    Optional<List<Review>> findAllByProductId(String productId);

    //    long countAllByProductIdAndReviewMessageNotNull (String productId);
    long countAllByProductId(String productId);
}
