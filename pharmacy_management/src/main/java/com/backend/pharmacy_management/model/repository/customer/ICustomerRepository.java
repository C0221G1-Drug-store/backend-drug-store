package com.backend.pharmacy_management.model.repository.customer;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
