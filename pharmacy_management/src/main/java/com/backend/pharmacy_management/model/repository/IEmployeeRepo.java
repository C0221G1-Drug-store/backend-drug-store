package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee, Long> {

}
