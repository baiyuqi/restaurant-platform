package com.dy.food.good.model;

import com.dy.food.commons.util.DateAudit;
import com.dy.food.good.web.GoodResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PRODUCT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Good extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PRODUCT_ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String name;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;
    private double price;

    @Column(name = "PRODUCT_IMAGE_ID")
    private String imageId;

    @Column(name = "PRODUCT_CATEGORY_ID")
    private String categoryId;

    @Column(name = "AVAILABLE_ITEM_COUNT")
    private int availableItemCount;
    
    private String restaurantId;

   
    public static GoodResponse fromEntity(Good good) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(good, GoodResponse.class);
    }
}
