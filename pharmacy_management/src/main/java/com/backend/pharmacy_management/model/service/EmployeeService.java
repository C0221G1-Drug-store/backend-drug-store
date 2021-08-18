package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.employee.Employee;

public interface EmployeeService {
    Employee findById(Long id);
}
