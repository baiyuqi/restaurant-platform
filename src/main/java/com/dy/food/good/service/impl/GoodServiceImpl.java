package com.dy.food.good.service.impl;

import com.dy.food.good.repository.GoodCategoryRepository;
import com.dy.food.good.repository.GoodRepository;
import com.dy.food.good.repository.ReviewRepository;
import com.dy.food.good.repository.dao.Good;
import com.dy.food.good.repository.dao.GoodCategory;
import com.dy.food.good.repository.dao.Review;
import com.dy.food.good.service.GoodService;
import com.dy.food.good.service.ReviewService;
import com.dy.food.good.web.CreateGoodRequest;
import com.dy.food.good.web.GoodResponse;
import com.dy.food.good.web.UpdateGoodRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodRepository goodRepository;

    @Autowired
    GoodCategoryRepository goodCategoryRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String createGood(@Valid CreateGoodRequest createGoodRequest) {

        Optional<GoodCategory> goodCategoryOptional =
                goodCategoryRepository.findById(createGoodRequest.getGoodCategoryId());

        GoodCategory goodCategory = goodCategoryOptional.orElseThrow(() -> new RuntimeException("GoodCategory doesn't exist!"));

        Good good = Good.builder()
                .goodName(createGoodRequest.getGoodName())
                .description(createGoodRequest.getDescription())
                .availableItemCount(createGoodRequest.getAvailableItemCount())
                .price(createGoodRequest.getPrice())
                .goodCategoryId(goodCategory.getGoodCategoryId())
                .imageId(createGoodRequest.getImageId())
                .build();


        Good savedGood = goodRepository.save(good);
        return savedGood.getGoodId();
    }

    @Override
    public GoodResponse getGood(String goodId) {
        Optional<Good> goodOptional =
                goodRepository.findById(goodId);

        Good good = goodOptional.orElseThrow(() -> new RuntimeException("Good Id doesn't exist!"));
        GoodResponse goodResponse = objectMapper.convertValue(good, GoodResponse.class);
        populateRatingForGood(goodId, goodResponse);
        return goodResponse;
    }

    //This way of setting rating for goodResponse is not okay, But this is okay for now.
    private void populateRatingForGood(String goodId, GoodResponse goodResponse) {
        List<Review> reviewsForGood = reviewService.getReviewsForGood(goodId);
        if (reviewsForGood.size() > 0) {
            double sum = reviewsForGood.stream().mapToDouble(Review::getRatingValue).sum();
            double rating = sum / reviewsForGood.size();
            goodResponse.setAverageRating(rating);
        }

        goodResponse.setNoOfRatings(Math.toIntExact(reviewRepository.countAllByGoodId(goodId)));
    }

    @Override
    public void deleteGood(String goodId) {

        goodRepository.deleteById(goodId);

    }

    @Override
    public void updateGood(UpdateGoodRequest updateGoodRequest) {

        Optional<Good> goodOptional =
                goodRepository.findById(updateGoodRequest.getGoodId());

        //check weather good exists
        final Good goodExisting = goodOptional.orElseThrow(() -> new RuntimeException("Good Id doesn't exist!"));

        goodExisting.setGoodId(updateGoodRequest.getGoodId());

        if (updateGoodRequest.getGoodName() != null) {
            goodExisting.setGoodName(updateGoodRequest.getGoodName());
        }

        if (updateGoodRequest.getDescription() != null) {
            goodExisting.setDescription(updateGoodRequest.getDescription());
        }

        if (updateGoodRequest.getPrice() != null) {
            goodExisting.setPrice(updateGoodRequest.getPrice());
        }

        if (updateGoodRequest.getImageId() != null) {
            goodExisting.setImageId(updateGoodRequest.getImageId());
        }

        if (updateGoodRequest.getGoodCategoryId() != null) {
            Optional<GoodCategory> goodCategoryOptional =
                    goodCategoryRepository.findById(updateGoodRequest.getGoodCategoryId());

            //check weather good category exists
            GoodCategory goodCategory = goodCategoryOptional.orElseThrow(() -> new RuntimeException("GoodCategory doesn't exist!"));
            goodExisting.setGoodCategoryId(goodCategory.getGoodCategoryId());
        }

        if (updateGoodRequest.getAvailableItemCount() != null) {
            goodExisting.setAvailableItemCount(updateGoodRequest.getAvailableItemCount());
        }

        goodExisting.setCreatedAt(goodExisting.getCreatedAt());

        goodRepository.save(goodExisting);
    }

    @Override
    public Page<Good> findAllGoods(Pageable pageable) {
        return goodRepository.findAll(pageable);
    }
    
    @Override
    public Page<GoodResponse> getAllGoods(String sort, Integer page, Integer size) {
        
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
                throw new RuntimeException("Not a valid sort value, It should be 'fieldName,direction', example : 'goodName,asc");
            }
            
        }
        Page<Good> allGoods = goodRepository.findAll(pageable);
        Page<GoodResponse> allGoodsResponse = allGoods.map(Good::fromEntity);
        allGoodsResponse.forEach(goodResponse -> populateRatingForGood(goodResponse.getGoodId(), goodResponse));

        return allGoodsResponse;
    }
}
