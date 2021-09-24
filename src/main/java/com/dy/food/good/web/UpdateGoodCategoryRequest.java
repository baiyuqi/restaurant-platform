package com.dy.food.good.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGoodCategoryRequest {

    @NotNull(message = "goodCategoryId should not be null!")
    @NotEmpty(message = "goodCategoryId should not be empty!")
    private String goodCategoryId;

    @NotNull(message = "goodCategoryName should not be null!")
    @NotEmpty(message = "goodCategoryName should not be empty!")
    private String goodCategoryName;
    private String description;

}
