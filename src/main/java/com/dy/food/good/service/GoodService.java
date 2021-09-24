package com.dy.food.good.service;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dy.food.good.repository.dao.Good;
import com.dy.food.good.web.CreateGoodRequest;
import com.dy.food.good.web.GoodResponse;
import com.dy.food.good.web.UpdateGoodRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface GoodService {

  String createGood(@Valid CreateGoodRequest createGoodRequest);

  GoodResponse getGood(String goodId);

  void deleteGood(String goodId);

  void updateGood(UpdateGoodRequest updateGoodRequest);

  Page<Good> findAllGoods(Pageable pageable);

  Page<GoodResponse> getAllGoods(String sort, Integer page, Integer size);
}
