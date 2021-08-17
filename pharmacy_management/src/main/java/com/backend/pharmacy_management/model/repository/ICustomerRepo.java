package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.dto.lookup.CustomerLookup;
import com.backend.pharmacy_management.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {
    @Query(value = "select customer_code, customer_name, customer_age, " +
            "customer_address, customer_phone, customer_group_id, customer_note " +
            "from customer " +
            "where (customer_code like %?1%) and " +
            "(customer_name like %?2%) and " +
            "(customer_address like %?3%) and " +
            "(customer_phone like %?4%) and " +
            "(customer_group_id like %?5%)", nativeQuery = true)
    List<CustomerLookup> findALlBySearch(String code, String name, String address, String phone, String groupId);
}
