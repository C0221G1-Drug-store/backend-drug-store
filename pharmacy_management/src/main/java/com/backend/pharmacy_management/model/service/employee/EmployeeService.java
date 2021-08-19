package com.backend.pharmacy_management.model.service.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAllNormal() {
        return iEmployeeRepository.findAllNormal();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }


    @Override
    public void remove(Long id) {
        iEmployeeRepository.deleteById(id);
    }
}
