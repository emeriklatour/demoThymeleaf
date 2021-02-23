package com.colval.demothymeleaf.services.implementation;

import com.colval.demothymeleaf.model.entities.Customer;
import com.colval.demothymeleaf.repositories.interfaces.ICustomerRepository;
import com.colval.demothymeleaf.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> readOne(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomerSortedByLastName() {
        return customerRepository.findAllCustomerSortedByLastName();
    }

    @Override
    public Customer updateFirstNameAndLastName(Long customerId, String firstName, String lastName) {
        Optional<Customer> customerRecover = this.readOne(customerId);
        if (customerRecover.isEmpty()) throw new RuntimeException("Customer Id not found");
        Customer customer = customerRecover.get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerRepository.save(customer);
    }

    @Override
    public Long countAllCustomer() {
        return customerRepository.count();
    }

    @Override
    public List<Customer> findAllCustomerIdDescAndLimitTen() {
        return customerRepository.findAllCustomerIdDesc().stream().limit(10).collect(Collectors.toList());
    }
}
