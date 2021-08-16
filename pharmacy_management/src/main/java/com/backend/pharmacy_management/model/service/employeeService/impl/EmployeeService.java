package com.backend.pharmacy_management.model.service.employeeService.impl;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.repository.employee.EmployeeRepository;
import com.backend.pharmacy_management.model.service.employeeService.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

//    @Override
//    public Page<Employee> searchEmployee(String employeeName, String employeeAddress, String employeeCode, int position, String employeePhone, Pageable pageable) {
//        return employeeRepository.findEmployeeByRequest(employeeName, employeeAddress, employeeCode, position, employeePhone, pageable);
//    }

    @Override
    public Page<Employee> searchEmployee(String employeeName, String employeeAddress, String employeeCode,  String employeePhone, Pageable pageable) {
        return employeeRepository.findEmployeeByRequest(employeeName, employeeAddress, employeeCode, employeePhone, pageable);
    }
    @Override
    public List<Employee> search() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> showList() {
        return employeeRepository.findAll();
    }


}