package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ExportBillController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private ExportBillTypeService exportBillTypeService;
    @Autowired
    private ImportBillDrugService importBillDrugService;
    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ExportBillService exportBillService;

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

    @GetMapping("/drug")
    public ResponseEntity<List<Drug>> getAllDrug(){
        return new ResponseEntity<>(this.drugService.findAllDrug(), HttpStatus.OK);
    }

    @GetMapping("/importBillDrug/{importBillDrugId}")
    public ResponseEntity<ImportBillDrug> getDrugById(@PathVariable("importBillDrugId") Long id){
        return new ResponseEntity<>(this.importBillDrugService.findDrugByid(id),HttpStatus.OK);
    }


    @GetMapping("/importBillDrug/manufacturer/{manufacturerId}")
    public ResponseEntity<List<ImportBillDrug>> getAllImportByManufacturerId(@PathVariable("manufacturerId") Long id){
        return new ResponseEntity<>(this.importBillDrugService.getAllImportBillDrugByManufacuterId(id),HttpStatus.OK);
    }

    @GetMapping(value="/export-bill/createCode" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> createExportBillRefundCode() {
        String stringCode = this.exportBillService.createExportBillRefundCode();
        String[] response = {stringCode};
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
