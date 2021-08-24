package com.backend.pharmacy_management.model.repository.employeeRepository;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value="select * from pharmacy_management.employee where employee_name like %?1% and employee_address like %?2% and employee_code like %?3% and employee_phone like %?4% and `position` like %?5% ",nativeQuery=true)
    Page<Employee> findEmployeeByRequest(String employeeName, String employeeAddress , String employeeCode, String employeePhone, String position , Pageable pageable);
    @Query(value="select * from pharmacy_management.employee where concat(employee_name,employee_address, employee_code,employee_phone,`position`) like %?1% ",nativeQuery=true)
    Page<Employee>findEmployeeByFindAllField(String keyWord,Pageable pageable);
}
