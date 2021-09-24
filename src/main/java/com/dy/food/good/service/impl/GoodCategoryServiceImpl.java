package com.dy.food.good.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dy.food.good.repository.GoodCategoryRepository;
import com.dy.food.good.repository.dao.GoodCategory;
import com.dy.food.good.service.GoodCategoryService;
import com.dy.food.good.web.CreateGoodCategoryRequest;
import com.dy.food.good.web.UpdateGoodCategoryRequest;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@Service
public class GoodCategoryServiceImpl implements GoodCategoryService {

    @Autowired
    GoodCategoryRepository goodCategoryRepository;

    @Override
    public String createGoodCategory(
        @Valid CreateGoodCategoryRequest createGoodCategoryRequest) {

        GoodCategory goodCategory = GoodCategory.builder()
                .goodCategoryName(createGoodCategoryRequest.getGoodCategoryName())
                .description(createGoodCategoryRequest.getDescription())
                .build();

        GoodCategory savedGoodCategory = goodCategoryRepository.save(goodCategory);
        return savedGoodCategory.getGoodCategoryId();
    }

    @Override
    public GoodCategory getGoodCategory(String goodCategoryId) {

        Optional<GoodCategory> goodCategoryOptional = goodCategoryRepository.findById(goodCategoryId);

        GoodCategory goodCategory = goodCategoryOptional.orElseThrow(() -> new RuntimeException("Good Category doesn't exist!"));

        return goodCategory;
    }

    @Override
    public void deleteGoodCategory(String goodCategoryId) {

        goodCategoryRepository.deleteById(goodCategoryId);

    }

    @Override
    public void updateGoodCategory(UpdateGoodCategoryRequest updateGoodCategoryRequest) {

        //To check weather the GoodCategory exist.
        GoodCategory getGoodCategory =
                this.getGoodCategory(updateGoodCategoryRequest.getGoodCategoryId());

        GoodCategory goodCategory = GoodCategory.builder()
                .goodCategoryId(updateGoodCategoryRequest.getGoodCategoryId())
                .goodCategoryName(updateGoodCategoryRequest.getGoodCategoryName())
                .description(updateGoodCategoryRequest.getDescription())
                .build();

        goodCategory.setCreatedAt(getGoodCategory.getCreatedAt());

        goodCategoryRepository.save(goodCategory);

    }
    
    @Override
    public Page<GoodCategory> getAllGoodCategories(String sort, Integer page, Integer size) {
        
        //set defaults
        if (size == null || size == 0) {
            size = 20;
        }
        
        //set defaults
        if (page == null || page == 0) {
            page = 0;
        }
        
        Pageable pageable;
        
        if (sort == null) {
            pageable = PageRequest.of(page, size);
        } else {
            Sort.Order order;
            
            try {
                String[] split = sort.split(",");
                
                Sort.Direction sortDirection = Sort.Direction.fromString(split[1]);
                order = new Sort.Order(sortDirection, split[0]).ignoreCase();
                pageable = PageRequest.of(page, size, Sort.by(order));
                
            } catch (Exception e) {
                throw new RuntimeException("Not a valid sort value, It should be 'fieldName,direction', example : 'goodCategoryName,asc");
            }
            
        }
        
        return goodCategoryRepository.findAll(pageable);
    }
}
