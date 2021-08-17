package com.backend.pharmacy_management.model.service.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.repository.employee.IEmployeeRepository;
import com.backend.pharmacy_management.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }
}
