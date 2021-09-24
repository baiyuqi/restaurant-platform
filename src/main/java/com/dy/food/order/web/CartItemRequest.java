package com.dy.food.order.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-08-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemRequest {
    
    @NotNull(message = "goodId should not be null!")
    @NotEmpty(message = "goodId should not be empty!")
    private String goodId;

    @Min(message = "quantity should be greater than 0", value = 1)
    private Integer quantity;
    
}
