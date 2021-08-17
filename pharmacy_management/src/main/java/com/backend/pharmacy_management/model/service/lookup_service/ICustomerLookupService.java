package com.backend.pharmacy_management.model.service.lookup_service;

import com.backend.pharmacy_management.model.dto.lookup.CustomerLookup;
import com.backend.pharmacy_management.model.dto.lookup.ManufacturerLookup;
import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;

import java.util.List;

public interface ICustomerLookupService {
    List<CustomerLookup> findByKey(String code, String name, String address, String phone, String groupId);
    List<CustomerGroup> findAllCustomerGroup();
    List<ManufacturerLookup> findManufacturerByKey(String code, String name, String address, String phone);
}
