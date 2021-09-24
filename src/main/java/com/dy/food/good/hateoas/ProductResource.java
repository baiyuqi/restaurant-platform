package com.dy.food.good.hateoas;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import com.dy.food.good.model.Good;


/**
 * @author: Yuqi.Bai,
 * Date : 2019-08-27
 */
@Data
public class ProductResource extends EntityModel<Good> {
    
    private Pageable pageable;
    
    public ProductResource(Good content, Link... links) {
        EntityModel.of(content, links);
    }
}
