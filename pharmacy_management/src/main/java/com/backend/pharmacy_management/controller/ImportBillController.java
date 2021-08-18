package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.ExportBillDetailDto;
import com.backend.pharmacy_management.model.dto.ExportBillDto;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.service.IDrugService;
import com.backend.pharmacy_management.model.service.IEmployeeService;
import com.backend.pharmacy_management.model.service.IExportBillService;
import com.backend.pharmacy_management.model.service.IImportBillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImportBillController {
    @Autowired
    private IExportBillService exportBillService;

    @Autowired
    private IImportBillService importBillService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "/drug-import-bills")
    private ResponseEntity<List<ImportBillDrug>> getListDrug() {
        List<ImportBillDrug> drugs = this.importBillService.getListDrug();
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping(value = "/export-bill-types")
    private ResponseEntity<List<ExportBillType>> getListExportType() {
        List<ExportBillType> types = this.exportBillService.getListExportBillTye();
        if (types.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @PostMapping(value = "/export-bills")
    private ResponseEntity<ExportBill> createExportBill(@RequestBody @Valid ExportBillDto exportBillDto, BindingResult bindingResult) {
        new ExportBillDto().validate(exportBillDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ExportBill exportBill = new ExportBill();
        BeanUtils.copyProperties(exportBillDto, exportBill);
        exportBill.setEmployee(this.employeeService.findById(1L));
        this.exportBillService.createExportBill(exportBill);
        return new ResponseEntity<>(exportBill,HttpStatus.OK);
    }

    @PostMapping(value = "/export-bill-details")
    private ResponseEntity<Void> createExportBillDetail(@RequestBody @Valid ExportBillDetailDto exportBillDetailDto, BindingResult bindingResult) {
        new ExportBillDetailDto().validate(exportBillDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ExportBillDetail exportBillDetail = new ExportBillDetail();
        BeanUtils.copyProperties(exportBillDetailDto, exportBillDetail);
        this.exportBillService.createExportBillDetail(exportBillDetail);
        this.importBillService.updateDrugImportBill(exportBillDetail.getImportBillDrug().getImportBillDrugId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/export-bills/code", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String[]> createCodeExportBill() {
        String result = this.exportBillService.createCodeExportBill();
        String[] a = {result};
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
    @GetMapping(value ="/employees" )
    private ResponseEntity<Employee> getEmployee(){
        Employee employee = this.employeeService.findById(1L);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

}
