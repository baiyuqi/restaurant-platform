package com.dy.food.catalog.service;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dy.food.catalog.repository.dao.Product;
import com.dy.food.catalog.web.CreateProductRequest;
import com.dy.food.catalog.web.ProductResponse;
import com.dy.food.catalog.web.UpdateProductRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface ProductService {

  String createProduct(@Valid CreateProductRequest createProductRequest);

  ProductResponse getProduct(String productId);

  void deleteProduct(String productId);

  void updateProduct(UpdateProductRequest updateProductRequest);

  Page<Product> findAllProducts(Pageable pageable);

  Page<ProductResponse> getAllProducts(String sort, Integer page, Integer size);
}
