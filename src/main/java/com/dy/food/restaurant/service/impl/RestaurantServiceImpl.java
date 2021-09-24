package com.dy.food.restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dy.food.account.exception.SuccessCodeWithErrorResponse;
import com.dy.food.account.model.Role;
import com.dy.food.account.model.User;
import com.dy.food.account.repository.RoleRepository;
import com.dy.food.account.repository.UserRepository;
import com.dy.food.account.service.UserRoleService;
import com.dy.food.account.service.UserService;
import com.dy.food.account.web.CreateUserRequest;
import com.dy.food.account.web.GetUserInfoResponse;
import com.dy.food.account.web.GetUserResponse;
import com.dy.food.account.web.MapUserToRolesRequest;
import com.dy.food.account.web.UpdateUserRequest;
import com.dy.food.account.web.UpdateUserRequestFromAdmin;
import com.dy.food.commons.exception.Error;
import com.dy.food.commons.exception.ErrorResponse;
import com.dy.food.commons.exception.RunTimeExceptionPlaceHolder;
import com.dy.food.restaurant.repository.RestaurantRepository;
import com.dy.food.restaurant.service.RestaurantService;
import com.dy.food.restaurant.web.CreateRestaurantRequest;
import com.dy.food.restaurant.web.GetRestaurantResponse;
import com.dy.food.restaurant.web.UpdateRestaurantRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author: Yuqi.Bai, Date : 2019-06-30
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Override
	public String createRestaurant(CreateRestaurantRequest createRestaurantRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRestaurantResponse getRestaurantByRestaurantName(String RestaurantName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRestaurantResponse getRestaurantByRestaurantId(String RestaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRestaurant(UpdateRestaurantRequest updateRestaurantRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurantById(String RestaurantId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GetRestaurantResponse> getAllRestaurants() {
		// TODO Auto-generated method stub
		return null;
	}


}
