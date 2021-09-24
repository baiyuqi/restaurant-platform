package com.dy.food.good.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.food.good.repository.dao.Review;

import java.util.List;
import java.util.Optional;

/**
 * @author Yuqi.Bai, Date : 07-Nov-2020
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    Optional<Review> findByUserIdAndGoodId(String userId, String goodId);

    Optional<List<Review>> findAllByGoodId(String goodId);

    //    long countAllByGoodIdAndReviewMessageNotNull (String goodId);
    long countAllByGoodId(String goodId);
}
