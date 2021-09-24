package com.dy.food.good.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGoodRequest {

    @NotNull(message = "goodId should not be null!")
    @NotEmpty(message = "goodId should not be empty!")
    private String goodId;

    private String goodName;

    private String description;

    @Min(value = 0)
    private Double price;

    private String imageId;

    private String goodCategoryId;

    private Integer availableItemCount;

}
