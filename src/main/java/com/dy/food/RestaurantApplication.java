package com.dy.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Yuqi.Bai, Date : 2019-05-16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.dy.restaurant"})

public class RestaurantApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestaurantApplication.class, args);
  }

}
