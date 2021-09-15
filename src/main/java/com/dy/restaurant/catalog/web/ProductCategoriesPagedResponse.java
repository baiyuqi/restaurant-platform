package com.dy.restaurant.catalog.web;

import lombok.Data;
import org.springframework.data.domain.Page;

import com.dy.restaurant.catalog.repository.dao.ProductCategory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-08-29
 */
@Data
public class ProductCategoriesPagedResponse {
    
    Page<ProductCategory> page;
    Map<String, String> _links = new HashMap<>();
    
}
