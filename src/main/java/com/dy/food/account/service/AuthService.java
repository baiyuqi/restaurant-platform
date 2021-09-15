package com.dy.food.account.service;

import com.dy.food.account.web.CreateOAuthClientRequest;
import com.dy.food.account.web.CreateOAuthClientResponse;
import com.dy.food.account.web.CreateUserResponse;
import com.dy.food.account.web.SignInRequest;
import com.dy.food.account.web.SignUpRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
