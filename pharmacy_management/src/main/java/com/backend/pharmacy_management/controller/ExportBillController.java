package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.ExportBillDetailDto;
import com.backend.pharmacy_management.model.dto.ExportBillDto;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.service.*;
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
@CrossOrigin("http://localhost:4200/")
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

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/export-bill-type")
    public ResponseEntity<List<ExportBillType>> getAllExportBillType(){
        return new ResponseEntity<>(this.exportBillTypeService.findAllExportBillType(), HttpStatus.OK);
    }
    @GetMapping(value = "/manufacturer")
    public ResponseEntity<List<Manufacturer>> getAllManufacturer(){
        return new ResponseEntity<>(this.manufacturerService.findAllManufacturer(), HttpStatus.OK);
    }

    @GetMapping(value = "/importBillDrug")
    public ResponseEntity<List<ImportBillDrug>> getAllImportBillDrug(){
        return new ResponseEntity<>(this.importBillDrugService.findAllImportBill(), HttpStatus.OK);
    }

    @GetMapping(value = "/drug")
    public ResponseEntity<List<Drug>> getAllDrug(){
        return new ResponseEntity<>(this.drugService.findAllDrug(), HttpStatus.OK);
    }

    @GetMapping(value = "/importBillDrug/{importBillDrugId}")
    public ResponseEntity<ImportBillDrug> getDrugById(@PathVariable("importBillDrugId") Long id){
        return new ResponseEntity<>(this.importBillDrugService.findDrugByid(id),HttpStatus.OK);
    }


    @GetMapping(value = "/importBillDrug/manufacturer/{manufacturerId}")
    public ResponseEntity<List<ImportBillDrug>> getAllImportByManufacturerId(@PathVariable("manufacturerId") Long id){
        return new ResponseEntity<>(this.importBillDrugService.getAllImportBillDrugByManufacuterId(id),HttpStatus.OK);
    }

    @GetMapping(value="/export-bill/createCode" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> createExportBillRefundCode() {
        String stringCode = this.exportBillService.createExportBillRefundCode();
        String[] response = {stringCode};
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping(value="/export-bill/create-code-destroy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> createExportBillDestroyCode() {
        String stringCode = this.exportBillService.createExportBillDestroyCode();
        String[] response = {stringCode};
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping(value = "/export-bill")
    private ResponseEntity<ExportBill> createExportBill(@RequestBody @Valid ExportBillDto exportBillDto, BindingResult bindingResult) {
        new ExportBillDto().validate(exportBillDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ExportBill exportBill = new ExportBill();
        BeanUtils.copyProperties(exportBillDto, exportBill);
        exportBill.setEmployee(this.employeeService.findById(1L));
        this.exportBillService.createExportBill(exportBill);
        return new ResponseEntity<>(exportBill,HttpStatus.CREATED);
    }

    @PostMapping(value = "/export-bill/export-bill-detail")
    private ResponseEntity<Void> createExportBillDetail(@RequestBody @Valid ExportBillDetailDto exportBillDetailDto, BindingResult bindingResult) {
        new ExportBillDetailDto().validate(exportBillDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ExportBillDetail exportBillDetail = new ExportBillDetail();
        BeanUtils.copyProperties(exportBillDetailDto, exportBillDetail);
        this.exportBillService.createExportBillDetail(exportBillDetail);
        this.importBillDrugService.updateImportBillDrug(exportBillDetail.getImportBillDrug().getImportBillDrugId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value ="/employees")
    private ResponseEntity<Employee> getEmployee(){
        Employee employee = this.employeeService.findById(1L);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
