package com.backend.pharmacy_management.model.service.employee;


import com.backend.pharmacy_management.model.entity.employee.Employee;

import java.util.List;


public interface IEmployeeService {
    Employee findById(Long id);
    List<Employee> findAllNormal();
    void save(Employee employee);
    void remove(Long id);
}
