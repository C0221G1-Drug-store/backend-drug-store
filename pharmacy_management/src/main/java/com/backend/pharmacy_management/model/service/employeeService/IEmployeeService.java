package com.backend.pharmacy_management.model.service.employeeService;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.domain.Page;

public interface IEmployeeService {
    Page<Employee> searchEmployee();
}
