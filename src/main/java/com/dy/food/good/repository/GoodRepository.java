package com.dy.food.good.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.food.good.repository.dao.Good;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@Repository
public interface GoodRepository extends JpaRepository<Good, String> {
	public List<Good> findByProductCategoryId(String pcid);
}
