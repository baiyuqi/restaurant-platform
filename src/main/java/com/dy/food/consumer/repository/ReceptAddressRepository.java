package com.dy.food.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.food.account.model.User;
import com.dy.food.consumer.model.ReceptAddress;

public interface ReceptAddressRepository extends CrudRepository<ReceptAddress, String> {

}
