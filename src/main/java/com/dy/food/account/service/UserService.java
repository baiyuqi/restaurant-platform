package com.dy.food.account.service;

import java.util.List;

import com.dy.food.account.web.CreateUserRequest;
import com.dy.food.account.web.GetUserInfoResponse;
import com.dy.food.account.web.GetUserResponse;
import com.dy.food.account.web.UpdateUserRequest;
import com.dy.food.account.web.UpdateUserRequestFromAdmin;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface UserService {

  String createUser(CreateUserRequest createUserRequest);

  GetUserResponse getUserByUserName(String userName);

  GetUserResponse getUserByUserId(String userId);

  GetUserInfoResponse getUserInfo();

  void updateUserInfo(UpdateUserRequest updateUserRequest);

  void deleteUserById(String userId);

  List<GetUserResponse> getAllUsers();

  void updateUser(String userId, UpdateUserRequestFromAdmin updateUserRequestFromAdmin);
}
