package com.backend.pharmacy_management.model.service.employeeService;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> searchEmployee(String employeeName, String employeeAddress , String employeeCode, String employeePhone,String position , Pageable pageable);
    void deleteEmployee(long id);
    Page<Employee> getAll(Pageable pageable);
    Employee findById(long id);



}
