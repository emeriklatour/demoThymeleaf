package com.colval.demothymeleaf.services;

import com.colval.demothymeleaf.model.entities.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Address create(Address address);
    Optional<Address> readOne(Long addressId);
    List<Address> readAll();
    void delete(Long addressId);
}
