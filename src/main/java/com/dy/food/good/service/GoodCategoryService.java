package com.dy.food.catalog.service;

import javax.validation.Valid;
import org.springframework.data.domain.Page;

import com.dy.food.catalog.repository.dao.ProductCategory;
import com.dy.food.catalog.web.CreateProductCategoryRequest;
import com.dy.food.catalog.web.UpdateProductCategoryRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface ProductCategoryService {

  String createProductCategory(@Valid CreateProductCategoryRequest createProductCategoryRequest);

  ProductCategory getProductCategory(String productCategoryId);

  void deleteProductCategory(String productCategoryId);

  void updateProductCategory(UpdateProductCategoryRequest updateProductCategoryRequest);

  Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size);
}
