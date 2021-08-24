package com.backend.pharmacy_management.model.service.employee.impl;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.repository.employee.EmployeeRepository;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> searchEmployee(String employeeName, String employeeAddress, String employeeCode, String employeePhone ,String position, Pageable pageable) {
        return employeeRepository.findEmployeeByRequest(employeeName,employeeAddress,employeeCode,employeePhone,position,pageable);
    }
    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee saves(Employee employee) {
        List<Employee> employeeList = employeeRepository.findAll();
        String code = "";
        if (employeeList.isEmpty()) {
            code = "NV001";
        }else {
            Long lastId = employeeList.get(employeeList.size() - 1).getEmployeeId();
            if (lastId < 10) {
                code = "NV00" + (lastId + 1);
            } else if (lastId < 100) {
                code = "NV0" + (lastId + 1);
            }
        }
        employee.setEmployeeCode(code);
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployee(Long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}