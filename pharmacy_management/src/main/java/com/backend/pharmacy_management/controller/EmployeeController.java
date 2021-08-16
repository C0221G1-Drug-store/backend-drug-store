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
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>>findByRequest(@RequestParam Optional<String> employeeName, @RequestParam Optional<String> employeeAddress, @RequestParam Optional<String> employeeCode, @RequestParam Optional<String> employeePhone,
                                                       @RequestParam Optional<Integer> page,@RequestParam Optional<String> sortBy){
        Pageable pageable=PageRequest.of(page.orElse(0),5,Sort.Direction.ASC,sortBy.orElse("employee_name"));
//        String name="";
//        if (employeeName.isPresent()){
//            name=employeeName.get();
//        }
       Page<Employee> employeePage = employeeService.searchEmployee(employeeName.get(),employeeAddress.get(),employeeCode.get(),employeePhone.get(),pageable);

       return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }
//    @GetMapping("/employee/{employeeName}")
//    public ResponseEntity<List<Employee>> findByRequest1(@PathVariable String employeeName){
////        Page<Employee> employeePage = employeeService.searchEmployee1( employeeName.orElse("_"),page.orElse(0),sortBy.orElse("employee_id"));
////        Pageable pageable=PageRequest.of(page,5,Sort.Direction.ASC,sortBy);
//        List<Employee> employeeList=  employeeService.searchEmployee1(employeeName);
//       if (employeeList.isEmpty()){
//           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//       }
//        return new ResponseEntity<>(employeeList,HttpStatus.OK);
//    }
    @DeleteMapping("/employee-delete/{id}")
    public ResponseEntity<Employee>deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
