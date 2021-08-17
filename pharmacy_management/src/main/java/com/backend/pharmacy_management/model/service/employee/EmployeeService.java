package com.backend.pharmacy_management.model.service.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    @Override
    public Page<Employee> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return iEmployeeRepo.findById(id);
    }

    @Override
    public List<Employee> findAllNormal() {
        return null;
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepo.save(employee);
    }


    @Override
    public void remove(Long id) {

    }

    @Override
    public Employee saveE(Employee employee) {
        return iEmployeeRepo.save(employee);
    }
}
