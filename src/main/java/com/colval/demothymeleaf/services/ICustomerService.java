package com.colval.demothymeleaf.services;

import com.colval.demothymeleaf.model.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer create(Customer customer);

    Optional<Customer> readOne(Long id);

    List<Customer> readAll();

    void delete(Long id);

    List<Customer> getAllCustomerSortedByLastName();

    Customer updateFirstNameAndLastName(Long customerId,String firstName,String lastName);

    Long countAllCustomer();

    List<Customer> findAllCustomerIdDescAndLimitTen();

    List<Customer> getAllCustomerWithFirstLastNameSubStr(String subStr);



}
