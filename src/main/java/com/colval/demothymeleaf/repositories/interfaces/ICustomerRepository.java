package com.colval.demothymeleaf.repositories.interfaces;

import com.colval.demothymeleaf.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomerSortedByLastName();
    List<Customer> findAllCustomerIdDesc();
    List<Customer> findByFirstNameSubStr(String subStr);
}
