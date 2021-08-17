package com.backend.pharmacy_management.model.service.lookup_service;

import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import com.backend.pharmacy_management.model.service.IGeneralService;

import java.util.Optional;

public interface ICustomerGroupService extends IGeneralService<CustomerGroup> {
    Optional<CustomerGroup> findAllByName(String name);

}
