package com.backend.pharmacy_management.model.service.employee.impl;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.repository.employee.EmployeeRepository;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> searchEmployee(String employeeName, String employeeAddress, String employeeCode, String employeePhone , String position, Pageable pageable) {
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
    public Page<Employee> searchEmployee(String keyWord, Pageable pageable) {
        return employeeRepository.findEmployeeByFindAllField(keyWord, pageable);
    }
}