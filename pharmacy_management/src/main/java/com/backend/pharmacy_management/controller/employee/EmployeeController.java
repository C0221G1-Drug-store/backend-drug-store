package com.backend.pharmacy_management.controller.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/create")
    public void save(@RequestBody Employee employee) {
         employeeService.save(employee);
    }}
