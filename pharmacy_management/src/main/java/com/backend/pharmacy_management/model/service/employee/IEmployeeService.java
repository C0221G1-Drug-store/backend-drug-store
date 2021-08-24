package com.backend.pharmacy_management.model.service.employee;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface IEmployeeService {
    Page<Employee> searchEmployee(String employeeName, String employeeAddress , String employeeCode, String employeePhone,String position , Pageable pageable);
    void deleteEmployee(long id);
    Employee findById(long id);
    Employee saves(Employee employee);
    Employee findEmployee(Long id);
    Employee updateEmployee(Employee employee);
}
