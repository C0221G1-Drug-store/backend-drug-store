package com.backend.pharmacy_management.model.repository.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
