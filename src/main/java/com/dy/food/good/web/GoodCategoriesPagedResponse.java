package com.dy.food.good.web;

import lombok.Data;
import org.springframework.data.domain.Page;

import com.dy.food.good.repository.dao.GoodCategory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-08-29
 */
@Data
public class GoodCategoriesPagedResponse {
    
    Page<GoodCategory> page;
    Map<String, String> _links = new HashMap<>();
    
}
