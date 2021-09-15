package com.dy.restaurant.billing.service;

import java.util.List;

import com.dy.restaurant.billing.web.CreateAddressRequest;
import com.dy.restaurant.billing.web.GetAddressResponse;
import com.dy.restaurant.billing.web.UpdateAddressRequest;

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
