package com.dy.restaurant.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.restaurant.catalog.repository.dao.Product;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
