package com.backend.pharmacy_management.controller;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>>findEmployeeByRequest(@RequestParam Optional<String> employeeName, @RequestParam Optional<String> employeeAddress, @RequestParam Optional<String> employeeCode, @RequestParam Optional<String> employeePhone,
                                                       @RequestParam Optional<String> position,
                                                       @RequestParam Optional<Integer> page,@RequestParam Optional<String> sortBy){
        Pageable pageable=PageRequest.of(page.orElse(0),5,Sort.Direction.ASC,sortBy.orElse("employee_id"));
        Page<Employee> employeePage = employeeService.searchEmployee(employeeName.orElse(""),employeeAddress.orElse(""),employeeCode.orElse(""),employeePhone.orElse(""),position.orElse(""),pageable);
        if (employeePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }
    @DeleteMapping("/employee/delete")
    public ResponseEntity<Employee>deleteEmployee(@RequestParam long id){
        Employee  employee= employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
    }
    @GetMapping(" n")
    public ResponseEntity<Page<Employee>>findEmployeeByRequest(@RequestParam Optional<String> keyWord,
                                                               @RequestParam Optional<Integer> page,@RequestParam Optional<String> sortBy){
        Pageable pageable=PageRequest.of(page.orElse(0),5,Sort.Direction.ASC,sortBy.orElse("employee_id"));
        Page<Employee> employeePage = employeeService.searchEmployee(keyWord.orElse(""),pageable);
        if (employeePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    }
