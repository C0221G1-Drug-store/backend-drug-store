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
    }

//    @PostMapping("/create")
//    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
//
//        // Check provider
//
//        // Create vaccine
//        vaccineService.createVaccine(createVaccineDTO);
//
//        Vaccine vaccine = vaccineService.searchName(createVaccineDTO.getNameVaccine());
//
//        storageService.createStorage((int) createVaccineDTO.getQuantity(), vaccine.getVaccineId());
//        invoiceService.createInvoice(createVaccineDTO.getExpired(), createVaccineDTO.getUnitPrice(),
//                (int) createVaccineDTO.getQuantity(), createVaccineDTO.getDayReceive(),
//                provider.getProviderId(), vaccine.getVaccineId());
//        HttpHeaders httpHeaders = new HttpHeaders();
//
//        return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
//    }
}
