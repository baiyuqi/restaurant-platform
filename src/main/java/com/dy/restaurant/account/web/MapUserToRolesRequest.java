package com.dy.restaurant.account.web;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Yuqi.Bai, Date : 2019-07-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapUserToRolesRequest {

  private List<String> roleNames;
}
