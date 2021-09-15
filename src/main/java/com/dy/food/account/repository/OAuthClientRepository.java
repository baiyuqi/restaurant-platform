package com.dy.food.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.dy.food.account.repository.dao.OAuthClient;

/**
 * @author: Yuqi.Bai, Date : 2019-05-18
 */
public interface OAuthClientRepository extends CrudRepository<OAuthClient, Long> {

}
