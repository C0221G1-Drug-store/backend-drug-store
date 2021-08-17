package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICustomerGroupRepo extends JpaRepository<CustomerGroup, Long> {

}
