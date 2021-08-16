package com.backend.pharmacy_management.model.service.employeeService;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> searchEmployee(String employeeName, String employeeAddress , String employeeCode, String employeePhone , Pageable pageable);
    List<Employee> search();
    void deleteEmployee(long id);
    List<Employee> showList();
}
