
package com.backend.pharmacy_management.model.repository.customer;


import com.backend.pharmacy_management.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * " +
            "from customer " +
            "where (customer_code like ?1) " +
            "and (customer_name like ?2) " +
            "and (customer_address like ?3) " +
            "and (customer_phone like ?4) " +
            "and (customer_group_id like ?5) "
            + "and (flag = 1)"
            , nativeQuery = true)
    Page<Customer> findALlCusByKey (String code, String name, String address, String phone, String groupId, Pageable pageable);

    @Query(value = "select * " +
            "from customer " +
            "where (customer_code like ?1) " +
            "or (customer_name like ?2) " +
            "or (customer_address like ?3) " +
            "or (customer_phone like ?4) " +
            "or (customer_group_id like ?5) "
            + "and (flag = 1)"
            , nativeQuery = true)
    Page<Customer> findALlCustomersByKey (String code, String name, String address, String phone, String groupId, Pageable pageable);

}

