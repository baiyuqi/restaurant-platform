package com.dy.food.restaurant.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dy.food.restaurant.service.RestaurantService;
import com.dy.food.restaurant.web.CreateRestaurantRequest;
import com.dy.food.restaurant.web.GetRestaurantResponse;
import com.dy.food.restaurant.web.UpdateRestaurantRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-06-30
 */
@RestController
@CrossOrigin
public class CreateRestaurantRequestController {

  @Autowired
  private RestaurantService restaurantService;

  @PostMapping("/restaurant")
  @PreAuthorize("hasAuthority('ADMIN_Restaurant')")
  public ResponseEntity<?> createRestaurant(@RequestBody @Valid CreateRestaurantRequest createRestaurantRequest) {

    String RestaurantId = restaurantService.createRestaurant(createRestaurantRequest);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{RestaurantId}")
        .buildAndExpand(RestaurantId).toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping("/restaurant")
  @PreAuthorize("hasAuthority('ADMIN_Restaurant')")
  public ResponseEntity<GetRestaurantResponse> getRestaurant(
      @RequestParam("RestaurantName") Optional<String> RestaurantName
      , @RequestParam("RestaurantId") Optional<String> RestaurantId) {

    GetRestaurantResponse Restaurant = null;
    if (RestaurantName.isPresent()) {
      Restaurant = restaurantService.getRestaurantByRestaurantName(RestaurantName.get());
    } else if (RestaurantId.isPresent()) {
      Restaurant = restaurantService.getRestaurantByRestaurantId(RestaurantId.get());
    }
    return ResponseEntity.ok(Restaurant);
  }

  @PutMapping("/restaurant/{restaurantId}")
  @PreAuthorize("hasAuthority('ADMIN_Restaurant')")
  public ResponseEntity<?> updateRestaurant(@PathVariable("RestaurantId") String RestaurantId,
                                      @RequestBody @Valid UpdateRestaurantRequest updateRestaurantRequest) {

    restaurantService.updateRestaurant(updateRestaurantRequest);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/restaurants")
  @PreAuthorize("hasAuthority('ADMIN_Restaurant')")
  public ResponseEntity<List<GetRestaurantResponse>> getAllRestaurants() {
    List<GetRestaurantResponse> allRestaurants = restaurantService.getAllRestaurants();
    return ResponseEntity.ok(allRestaurants);
  }

  @GetMapping("/restaurantInfo")
  public ResponseEntity<GetRestaurantResponse> getRestaurantInfo(String resId) {
    GetRestaurantResponse RestaurantInfo = restaurantService.getRestaurantByRestaurantId(resId);
    return new ResponseEntity<>(RestaurantInfo, HttpStatus.OK);
  }

  @PutMapping("/RestaurantInfo")
  public ResponseEntity<?> updateRestaurantInfo(@RequestBody @Valid UpdateRestaurantRequest updateRestaurantRequest) {
    restaurantService.updateRestaurant(updateRestaurantRequest);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/Restaurant/{RestaurantId}")
  @PreAuthorize("hasAuthority('ADMIN_Restaurant')")
  public ResponseEntity<?> deleteRestaurantById(@PathVariable("RestaurantId") String RestaurantId){
    restaurantService.deleteRestaurantById(RestaurantId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
