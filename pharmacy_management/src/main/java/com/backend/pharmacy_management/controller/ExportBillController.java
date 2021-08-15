package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.service.ExportBillTypeService;
import com.backend.pharmacy_management.model.service.ImportBillDrugService;
import com.backend.pharmacy_management.model.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ExportBillController {

    @Autowired
    private ExportBillTypeService exportBillTypeService;
    @Autowired
    private ImportBillDrugService importBillDrugService;
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/export-bill-type")
    public ResponseEntity<List<ExportBillType>> getAllExportBillType(){
        return new ResponseEntity<>(this.exportBillTypeService.findAllExportBillType(), HttpStatus.OK);
    }
    @GetMapping("/manufacturer")
    public ResponseEntity<List<Manufacturer>> getAllManufacturer(){
        return new ResponseEntity<>(this.manufacturerService.findAllManufacturer(), HttpStatus.OK);
    }

    @GetMapping("/importBillDrug")
    public ResponseEntity<List<ImportBillDrug>> getAllImportBillDrug(){
        return new ResponseEntity<>(this.importBillDrugService.findAllImportBill(), HttpStatus.OK);
    }

}
