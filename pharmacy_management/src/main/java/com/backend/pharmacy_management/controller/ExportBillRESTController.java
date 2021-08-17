package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/export-bill")
@RequestMapping(value = "/export-bill")
public class ExportBillRESTController {

    @Autowired
    IExportBillService iExportBillService;


    @GetMapping("")
    public ResponseEntity<Page<ExportBill>> getExportBill(@PageableDefault(size = 10) Pageable pageable) {
        Page<ExportBill> exportBillPage = this.iExportBillService.findAll(pageable);
        return new ResponseEntity<>(exportBillPage, HttpStatus.OK);
    }

    @GetMapping(value = "find/{id}")
    public ResponseEntity<ExportBill> getExportBillById(@PathVariable(value = "id") Long id){
        ExportBill exportBill = this.iExportBillService.findById(id);
        return new ResponseEntity<>(exportBill, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{dateCreate}/{toDate}/{timeCreate}/{toTime}/{type}")
    public ResponseEntity<Page<ExportBill>> getExportBillByFields(@PageableDefault(size = 10) Pageable pageable,
                                                                  @PathVariable(value = "dateCreate") String dateCreate,
                                                                  @PathVariable(value = "toDate") String toDate,
                                                                  @PathVariable(value = "timeCreate") String timeCreate,
                                                                  @PathVariable(value = "toTime") String toTime,
                                                                  @PathVariable(value = "type") Long typeId) {
        Page<ExportBill> exportBillPage = this.iExportBillService.findByFields(dateCreate, toDate, timeCreate, toTime, typeId, pageable);
        return new ResponseEntity<>(exportBillPage, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable(value = "id") Long id) {
        ExportBill exportBill = this.iExportBillService.findById(id);
//        if (exportBill != null) {
            iExportBillService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        test.setFlag(true);
//        return new ResponseEntity<>(HttpEntity.EMPTY);
    }

}
