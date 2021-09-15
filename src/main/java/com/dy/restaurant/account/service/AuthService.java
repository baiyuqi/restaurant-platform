package com.dy.restaurant.account.service;

import com.dy.restaurant.account.web.CreateOAuthClientRequest;
import com.dy.restaurant.account.web.CreateOAuthClientResponse;
import com.dy.restaurant.account.web.CreateUserResponse;
import com.dy.restaurant.account.web.SignInRequest;
import com.dy.restaurant.account.web.SignUpRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
