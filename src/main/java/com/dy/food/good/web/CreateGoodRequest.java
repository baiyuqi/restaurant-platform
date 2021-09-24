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
public class CreateGoodRequest {

    @NotNull(message = "goodName should not be null!")
    @NotEmpty(message = "goodName should not be empty!")
    private String goodName;

    private String description;

    @Min(value = 0)
    private double price;

    private String imageId;

    @NotNull(message = "goodCategoryId should not be null!")
    @NotEmpty(message = "goodCategoryId should not be empty!")
    private String goodCategoryId;

    private int availableItemCount;

}
