package com.dy.food.restaurant.service;

import java.util.List;

import com.dy.food.restaurant.web.GetRestaurantResponse;
import com.dy.food.restaurant.web.UpdateRestaurantRequest;
import com.dy.food.restaurant.web.CreateRestaurantRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface RestaurantService {

  String createRestaurant(CreateRestaurantRequest createRestaurantRequest);

  GetRestaurantResponse getRestaurantByRestaurantName(String RestaurantName);

  GetRestaurantResponse getRestaurantByRestaurantId(String RestaurantId);

  void updateRestaurant(UpdateRestaurantRequest updateRestaurantRequest);

  void deleteRestaurantById(String RestaurantId);

  List<GetRestaurantResponse> getAllRestaurants();

}
