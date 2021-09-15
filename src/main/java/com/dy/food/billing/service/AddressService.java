package com.dy.food.billing.service;

import java.util.List;

import com.dy.food.billing.web.CreateAddressRequest;
import com.dy.food.billing.web.GetAddressResponse;
import com.dy.food.billing.web.UpdateAddressRequest;

/**
 * @author: Yuqi.Bai, Date : 2019-09-27
 */
public interface AddressService {

  void createAddress(CreateAddressRequest createAddressRequest);

  List<GetAddressResponse> getAddress();

  void updateAddress(UpdateAddressRequest updateAddressRequest);

  GetAddressResponse getAddressById(String addressId);

  void deleteAddressById(String addressId);
}
