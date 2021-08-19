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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @PostMapping( value = "/export-bill")
    public ResponseEntity<ExportBill> createExportBill(@RequestBody @Valid ExportBillDto exportBillDto, BindingResult bindingResult) {
        new ExportBillDto().validate(exportBillDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ExportBill exportBill = new ExportBill();
        BeanUtils.copyProperties(exportBillDto, exportBill);
        exportBill.setEmployee(this.employeeService.findById(exportBillDto.getEmployee().getEmployeeId()));
        this.exportBillService.createExportBill(exportBill);
        return new ResponseEntity<>(exportBill,HttpStatus.CREATED);
    }

    @PostMapping(value = "/export-bill/export-bill-detail")
    public ResponseEntity<Void> createExportBillDetail(@RequestBody @Valid ExportBillDetailDto exportBillDetailDto, BindingResult bindingResult) {
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

    @GetMapping(value ="/employees" )
    public ResponseEntity<Employee> getEmployee(){
        Employee employee = this.employeeService.findById(1L);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    //List
    @GetMapping("")
    public ResponseEntity<Page<ExportBill>> getExportBill(@PageableDefault(size = 10) Pageable pageable) {
        Page<ExportBill> exportBillPage = this.exportBillService.findAll(pageable);
        return new ResponseEntity<>(exportBillPage, HttpStatus.OK);
    }

    @GetMapping(value = "find/{id}")
    public ResponseEntity<ExportBill> getExportBillById(@PathVariable(value = "id") Long id){
        ExportBill exportBill = this.exportBillService.findById(id);
        return new ResponseEntity<>(exportBill, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{dateCreate}/{toDate}/{timeCreate}/{toTime}/{type}")
    public ResponseEntity<Page<ExportBill>> getExportBillByFields(@PageableDefault(size = 10) Pageable pageable,
                                                                  @PathVariable(value = "dateCreate") String dateCreate,
                                                                  @PathVariable(value = "toDate") String toDate,
                                                                  @PathVariable(value = "timeCreate") String timeCreate,
                                                                  @PathVariable(value = "toTime") String toTime,
                                                                  @PathVariable(value = "type") Long typeId) {
        Page<ExportBill> exportBillPage = this.exportBillService.findByFields(dateCreate, toDate, timeCreate, toTime, typeId, pageable);
        return new ResponseEntity<>(exportBillPage, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ExportBill> deleteTest(@PathVariable(value = "id") Long id) {
        ExportBill exportBill = this.exportBillService.findById(id);
        this.exportBillService.delete(id);
        return new ResponseEntity<>(exportBill, HttpStatus.OK);

    }
}
