package com.dy.food.good.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.food.good.repository.dao.GoodCategory;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@Repository
public interface GoodCategoryRepository extends JpaRepository<GoodCategory, String> {
}
