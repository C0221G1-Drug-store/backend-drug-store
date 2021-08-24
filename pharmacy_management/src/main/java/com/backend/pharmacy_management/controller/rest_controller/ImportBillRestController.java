package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.ImportBillDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.Payment;
import com.backend.pharmacy_management.model.service.import_bill.IImportBillService;
import com.backend.pharmacy_management.model.service.import_bill.IPaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/importBills")
public class ImportBillRestController {
    private final IImportBillService importBillService;

    @Autowired
    public ImportBillRestController(IImportBillService importBillService) {
        this.importBillService = importBillService;
    }

    @GetMapping
    public ResponseEntity<List<ImportBill>> getAll() {
        List<ImportBill> importBills = importBillService.findAllNormal();
        if (importBills.isEmpty()) {
            return new ResponseEntity<List<ImportBill>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

    @PostMapping(value= "", consumes={"application/json"})
    public ResponseEntity<ImportBill> create(@Valid @RequestBody ImportBillDto importBillDto) {
        ImportBill importBill = new ImportBill();
        BeanUtils.copyProperties(importBillDto, importBill);
        this.importBillService.save(importBill);
        return new ResponseEntity<>(importBill,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImportBill> getImportBills(@PathVariable Long id) {
        Optional<ImportBill> importBill = importBillService.findById(id);
        return new ResponseEntity<>(importBill.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImportBill> update(@Valid @RequestBody ImportBillDto importBillDto, @PathVariable Long id) {
        ImportBill importBill = new ImportBill();
        BeanUtils.copyProperties(importBillDto, importBill);
        importBill.setImportBillId(id);
        this.importBillService.save(importBill);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
