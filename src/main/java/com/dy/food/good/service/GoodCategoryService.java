package com.dy.food.good.service;

import javax.validation.Valid;
import org.springframework.data.domain.Page;

import com.dy.food.good.repository.dao.GoodCategory;
import com.dy.food.good.web.CreateGoodCategoryRequest;
import com.dy.food.good.web.UpdateGoodCategoryRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface GoodCategoryService {

  String createGoodCategory(@Valid CreateGoodCategoryRequest createGoodCategoryRequest);

  GoodCategory getGoodCategory(String goodCategoryId);

  void deleteGoodCategory(String goodCategoryId);

  void updateGoodCategory(UpdateGoodCategoryRequest updateGoodCategoryRequest);

  Page<GoodCategory> getAllGoodCategories(String sort, Integer page, Integer size);
}
