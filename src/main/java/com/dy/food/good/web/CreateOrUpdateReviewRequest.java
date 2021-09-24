package com.dy.food.good.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Yuqi.Bai, Date : 07-Nov-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateReviewRequest {

    @NotNull(message = "goodId should not be null!")
    @NotEmpty(message = "goodId should not be empty!")
    private String goodId;

    private String reviewMessage;

    @Min(value = 1)
    @Max(value = 5)
    private double ratingValue;
}
