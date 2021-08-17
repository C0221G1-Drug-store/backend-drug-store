package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.ImportBillDrugDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.service.import_bill.IImportBillDrugService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/importBillDrugs")
public class ImportBillDrugRestController {
    private final IImportBillDrugService importBillDrugService;

    public ImportBillDrugRestController(IImportBillDrugService importBillDrugService) {
        this.importBillDrugService = importBillDrugService;
    }
    @GetMapping
    public ResponseEntity<List<ImportBillDrug>> getAll() {
        List<ImportBillDrug> importBillDrugs = importBillDrugService.findAllNormal();
        if (importBillDrugs.isEmpty()) {
            return new ResponseEntity<List<ImportBillDrug>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDrugs, HttpStatus.OK);
    }

    @PostMapping(value= "", consumes={"application/json"})
    public ResponseEntity<ImportBillDrug> create(@Valid @RequestBody ImportBillDrugDto importBillDrugDto) {
        ImportBillDrug importBillDrug = new ImportBillDrug();
        BeanUtils.copyProperties(importBillDrugDto, importBillDrug);
        this.importBillDrugService.save(importBillDrug);
        return new ResponseEntity<>(importBillDrug,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImportBillDrug> getImportBillDrugs(@PathVariable Long id) {
        Optional<ImportBillDrug> importBillDrug = importBillDrugService.findById(id);
        return new ResponseEntity<>(importBillDrug.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImportBillDrug> update(@Valid @RequestBody ImportBillDrugDto importBillDrugDto, @PathVariable Long id) {
        ImportBillDrug importBillDrug = new ImportBillDrug();
        BeanUtils.copyProperties(importBillDrugDto, importBillDrug);
        this.importBillDrugService.save(importBillDrug);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
