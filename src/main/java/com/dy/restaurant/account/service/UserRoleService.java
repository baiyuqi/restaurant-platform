package com.dy.restaurant.account.service;

import com.dy.restaurant.account.web.MapRoleToUsersRequest;
import com.dy.restaurant.account.web.MapUserToRolesRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface UserRoleService {

  void mapUserToRoles(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void removeRolesFromUser(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void mapRoleToUsers(String roleName, MapRoleToUsersRequest mapRoleToUsersRequest);
}
