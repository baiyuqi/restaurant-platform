package com.dy.restaurant.billing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dy.restaurant.billing.repository.AddressRepository;
import com.dy.restaurant.billing.repository.dao.AddressDao;
import com.dy.restaurant.billing.service.AddressService;
import com.dy.restaurant.billing.web.CreateAddressRequest;
import com.dy.restaurant.billing.web.GetAddressResponse;
import com.dy.restaurant.billing.web.UpdateAddressRequest;
import com.dy.restaurant.commons.util.CommonUtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: Yuqi.Bai, Date : 2019-09-20
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void createAddress(CreateAddressRequest createAddressRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        AddressDao addressDao = AddressDao.builder()
                .addressLine1(createAddressRequest.getAddressLine1())
                .addressLine2(createAddressRequest.getAddressLine2())
                .city(createAddressRequest.getCity())
                .country(createAddressRequest.getCountry())
                .phone(createAddressRequest.getPhone())
                .postalCode(createAddressRequest.getPostalCode())
                .state(createAddressRequest.getState())
                .userId(userIdFromToken)
                .build();

        addressRepository.save(addressDao);

    }


    @Override
    public List<GetAddressResponse> getAddress() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        Optional<List<AddressDao>> addresses = addressRepository
                .findByUserId(userIdFromToken);

        List<GetAddressResponse> responseList = new ArrayList<>();

        if (addresses.isPresent()) {
            addresses.get().forEach(address -> {
                responseList.add(GetAddressResponse.builder()
                        .addressId(address.getAddressId())
                        .addressLine1(address.getAddressLine1())
                        .addressLine2(address.getAddressLine2())
                        .city(address.getCity())
                        .country(address.getCountry())
                        .phone(address.getPhone())
                        .postalCode(address.getPostalCode())
                        .state(address.getState())
                        .userId(address.getUserId())
                        .build());
            });

            return responseList;
        }

        return new ArrayList<>();
    }

    @Override
    public void updateAddress(UpdateAddressRequest updateAddressRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        Optional<AddressDao> addressFromDb = addressRepository.findByAddressId(updateAddressRequest.getAddressId());

        if (addressFromDb.isPresent()) {
            if (!userIdFromToken.equals(addressFromDb.get().getUserId())) {
                throw new RuntimeException("UnAuthorized!");
            }
        } else {
            throw new RuntimeException("Address doesn't exist!");
        }

        AddressDao addressDao = AddressDao.builder()
                .addressId(updateAddressRequest.getAddressId())
                .addressLine1(updateAddressRequest.getAddressLine1())
                .addressLine2(updateAddressRequest.getAddressLine2())
                .city(updateAddressRequest.getCity())
                .country(updateAddressRequest.getCountry())
                .phone(updateAddressRequest.getPhone())
                .postalCode(updateAddressRequest.getPostalCode())
                .state(updateAddressRequest.getState())
                .userId(userIdFromToken)
                .build();

        addressRepository.save(addressDao);
    }

    @Override
    public GetAddressResponse getAddressById(String addressId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);

        Optional<AddressDao> addressOptional = addressRepository.findByAddressId(addressId);

        if (addressOptional.isPresent()) {
            AddressDao address = addressOptional.get();

            if (!address.getUserId().equals(userIdFromToken)) {
                throw new RuntimeException("UnAuthorized");
            }

            return GetAddressResponse.builder()
                    .addressId(address.getAddressId())
                    .addressLine1(address.getAddressLine1())
                    .addressLine2(address.getAddressLine2())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .phone(address.getPhone())
                    .postalCode(address.getPostalCode())
                    .state(address.getState())
                    .userId(address.getUserId())
                    .build();
        }

        throw new RuntimeException("Address doesn't exist");
    }

    @Override
    public void deleteAddressById(String addressId) {
        getAddressById(addressId);
        addressRepository.deleteById(addressId);
    }
}
