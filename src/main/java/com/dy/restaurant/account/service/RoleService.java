package com.dy.restaurant.account.service;

import java.util.List;

import com.dy.restaurant.account.repository.dao.Role;
import com.dy.restaurant.account.web.CreateRoleRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface RoleService {

  String createRole(CreateRoleRequest createRoleRequest);

  List<Role> getAllRoles();
}
