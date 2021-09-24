package com.dy.food.good.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yuqi.Bai, Date : 08-Nov-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodResponse {

    private String goodId;
    private String goodName;
    private String description;
    private double price;
    private String goodCategory;
    private int availableItemCount;
    private Double averageRating;
    private int noOfRatings;
    private String imageId;

}
