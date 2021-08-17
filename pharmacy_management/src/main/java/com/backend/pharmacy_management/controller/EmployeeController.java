package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.employeeService.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        String name="";
        if (employeeName.isPresent()){
            name=employeeName.get();
        }
        String address="";
        if (employeeAddress.isPresent()){
            address=employeeAddress.get();
        }
        String code="";
        if (employeeCode.isPresent()){
            code=employeeCode.get();
        }
        String phone="";
        if (employeePhone.isPresent()){
            phone=employeePhone.get();
        }
        Page<Employee> employeePage = employeeService.searchEmployee(name,address,code,phone,position.orElse(""),pageable);
        if (employeePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }
    @DeleteMapping("/employee-delete/{id}")
    public ResponseEntity<Employee>deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
