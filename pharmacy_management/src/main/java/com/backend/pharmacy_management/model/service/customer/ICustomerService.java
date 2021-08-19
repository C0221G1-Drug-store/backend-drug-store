package com.backend.pharmacy_management.model.service.customer;

import com.backend.pharmacy_management.model.entity.customer.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findById(Long id);
    List<Customer> findAllNormal();
    void save(Customer customer);
    void remove(Long id);
}
