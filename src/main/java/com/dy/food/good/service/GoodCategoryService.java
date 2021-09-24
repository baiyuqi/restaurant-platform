package com.dy.food.good.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dy.food.good.model.GoodCategory;
import com.dy.food.good.repository.GoodCategoryRepository;
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
public class  GoodCategoryService {

    @Autowired
    GoodCategoryRepository goodCategoryRepository;

    public String create(
        @Valid CreateGoodCategoryRequest createGoodCategoryRequest) {

        GoodCategory goodCategory = GoodCategory.builder()
                .name(createGoodCategoryRequest.getGoodCategoryName())
                .description(createGoodCategoryRequest.getDescription())
                .build();

        GoodCategory savedGoodCategory = goodCategoryRepository.save(goodCategory);
        return savedGoodCategory.getId();
    }

    public GoodCategory get(String goodCategoryId) {

        Optional<GoodCategory> goodCategoryOptional = goodCategoryRepository.findById(goodCategoryId);

        GoodCategory goodCategory = goodCategoryOptional.orElseThrow(() -> new RuntimeException("Good Category doesn't exist!"));

        return goodCategory;
    }

    public void delete(String goodCategoryId) {

        goodCategoryRepository.deleteById(goodCategoryId);

    }


    public void update(UpdateGoodCategoryRequest updateGoodCategoryRequest) {

        //To check weather the GoodCategory exist.
        GoodCategory getGoodCategory =
                this.get(updateGoodCategoryRequest.getGoodCategoryId());

        GoodCategory goodCategory = GoodCategory.builder()
                .id(updateGoodCategoryRequest.getGoodCategoryId())
                .name(updateGoodCategoryRequest.getGoodCategoryName())
                .description(updateGoodCategoryRequest.getDescription())
                .build();

        goodCategory.setCreatedAt(getGoodCategory.getCreatedAt());

        goodCategoryRepository.save(goodCategory);

    }

    public Page<GoodCategory> getAll(String sort, Integer page, Integer size) {
        
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
