package com.backend.pharmacy_management.model.service.customer;

import com.backend.pharmacy_management.model.dto.lookup.CustomerLookup;
import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.service.IGeneralService;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> findALlBySearch(String keyWord);
    List<CustomerLookup> findALlBySearch(String code, String name, String address, String phone, String groupId);
}
