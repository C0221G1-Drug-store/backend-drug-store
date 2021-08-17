package com.backend.pharmacy_management.model.service.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
       return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAllNormal() {
        return null;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {

    }
}
