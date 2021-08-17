package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.lookup.CustomerLookup;
import com.backend.pharmacy_management.model.dto.lookup.ManufacturerLookup;
import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import com.backend.pharmacy_management.model.service.lookup_service.ICustomerLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LookupController {
    @Autowired
    ICustomerLookupService iCustomerLookupService;

    @GetMapping("customer/search/{attribute}/{keyWord}")
    public ResponseEntity<List<CustomerLookup>> findALlByKey(@PathVariable String keyWord, @PathVariable String attribute) {
        List<CustomerLookup> customerLookups = null;
        keyWord = "%" + keyWord.split(",")[0] + "%";
        switch (attribute) {
            case "code":
                customerLookups = iCustomerLookupService.findByKey(keyWord, "%%", "%%", "%%", "%%");
                break;
            case "name":
                customerLookups = iCustomerLookupService.findByKey("%%", keyWord, "%%", "%%", "%%");
                break;
            case "address":
                customerLookups = iCustomerLookupService.findByKey("%%", "%%", keyWord, "%%", "%%");
                break;
            case "phone":
                customerLookups = iCustomerLookupService.findByKey("%%", "%%", "%%", keyWord, "%%");
                break;
            case "groupId":
                customerLookups = iCustomerLookupService.findByKey("%%", "%%", "%%", "%%", keyWord);
                break;
            case "all":
                customerLookups = iCustomerLookupService.findByKey(keyWord, keyWord, keyWord, keyWord, keyWord);
                break;
            default:
                System.out.println("Find not found");
        }
        if (customerLookups.isEmpty()) {
            System.out.println("Error");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println("Success");
            return new ResponseEntity<>(customerLookups, HttpStatus.OK);
    }

    @GetMapping("customerGroup")
    public ResponseEntity<List<CustomerGroup>> findAllCustomerGroup() {
        List<CustomerGroup> customerGroups = iCustomerLookupService.findAllCustomerGroup();
        if (customerGroups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerGroups, HttpStatus.OK);
    }

    @GetMapping("manufacturer/search/{attribute}/{keyWord}")
    public ResponseEntity<List<ManufacturerLookup>> findManuALlByKey(@PathVariable String keyWord, @PathVariable String attribute) {
        List<ManufacturerLookup> manufacturerLookups = null;
        keyWord = "%" + keyWord.split(",")[0] + "%";
        switch (attribute) {
            case "code":
                manufacturerLookups = iCustomerLookupService.findManufacturerByKey(keyWord, "%%", "%%", "%%");
                break;
            case "name":
                manufacturerLookups = iCustomerLookupService.findManufacturerByKey("%%", keyWord, "%%", "%%");
                break;
            case "address":
                manufacturerLookups = iCustomerLookupService.findManufacturerByKey("%%", "%%", keyWord, "%%");
                break;
            case "phone":
                manufacturerLookups = iCustomerLookupService.findManufacturerByKey("%%", "%%", "%%", keyWord);
                break;
            case "all":
                manufacturerLookups = iCustomerLookupService.findManufacturerByKey(keyWord, keyWord, keyWord, keyWord);
                break;
            default:
                System.out.println("Find not found");
        }
        if (manufacturerLookups.isEmpty()) {
            System.out.println("Error");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println("Success");
        return new ResponseEntity<>(manufacturerLookups, HttpStatus.OK);
    }
}
