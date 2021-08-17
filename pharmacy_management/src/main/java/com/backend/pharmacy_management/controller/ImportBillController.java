package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.service.IImportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/import-bills")
public class ImportBillController {
    @Autowired
    private IImportBillService importBillService;

    //    @GetMapping(value = "/list")
//    public ResponseEntity<List<ImportBill>> findAllImportBill() {
//        List<ImportBill> importBills = importBillService.findAll();
//        if (importBills.isEmpty()) {
//            return new ResponseEntity<>(importBills, HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(importBills, HttpStatus.OK);
//    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<ImportBill>> findAllImportBill(@RequestParam int index) {
        List<ImportBill> importBills = importBillService.getAllImportBill(index);
        if (importBills.isEmpty()) {
            return new ResponseEntity<>(importBills, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

    @GetMapping("/not-pagination")
    public ResponseEntity<List<ImportBill>> getAllImportBillNotPagination() {
        List<ImportBill> importBills = importBillService.getAllImportBillNotPagination();
        if (importBills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ImportBill>> search(@RequestParam(defaultValue = "") String importCode) {
        List<ImportBill> importBills = importBillService.search(importCode);
        if (importBills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
//        String importCodeValue = "";
//
//        if (importCode.isPresent()) {
//            importCodeValue = importCode.get();
//        }
//        List<ImportBill> importBills = importBillService.search(importCodeValue);
//
//        if (importBills.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

    @GetMapping(value = "/search-bills")
    public ResponseEntity<List<ImportBill>> searchBill(@RequestParam(defaultValue = "") String codeBill,
                                                       @RequestParam(defaultValue = "") String startDate,
                                                       @RequestParam(defaultValue = "") String endDate,
                                                       @RequestParam(defaultValue = "") String col) {
        List<ImportBill> importBills = importBillService.selName(codeBill, startDate, endDate,col);
        if (importBills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

//    @GetMapping(value = "/sort")
//    public ResponseEntity<List<ImportBill>> sort(@RequestParam("field") Optional<String> field) {
//        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse(""));
//        List<ImportBill> importBills = importBillService.findAll(sort);
//        if (importBills.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(importBills, HttpStatus.OK);
//    }


}

