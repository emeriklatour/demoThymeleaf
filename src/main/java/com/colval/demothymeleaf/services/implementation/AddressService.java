package com.colval.demothymeleaf.services.implementation;

import com.colval.demothymeleaf.model.entities.Address;
import com.colval.demothymeleaf.repositories.interfaces.IAddressRepository;
import com.colval.demothymeleaf.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private final IAddressRepository addressRepository;

    @Autowired
    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> readOne(Long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public List<Address> readAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
