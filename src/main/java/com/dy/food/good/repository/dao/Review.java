package com.dy.food.good.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import com.dy.food.commons.util.DateAudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Yuqi.Bai, Date : 07-Nov-2020
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "REVIEW")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "REVIEW_ID", updatable = false, nullable = false)
    private String reviewId;

    @Column(name = "PRODUCT_ID", updatable = false, nullable = false)
    private String goodId;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "RATING_VALUE", nullable = false)
    @Min(1)
    @Max(5)
    private double ratingValue;

    @Column(name = "REVIEW_MESSAGE")
    private String reviewMessage;

}
