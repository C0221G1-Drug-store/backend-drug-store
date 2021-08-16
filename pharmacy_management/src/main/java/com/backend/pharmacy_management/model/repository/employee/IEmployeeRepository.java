package com.backend.pharmacy_management.model.repository.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
