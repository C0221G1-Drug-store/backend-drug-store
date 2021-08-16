package com.backend.pharmacy_management.controller.report;

import com.backend.pharmacy_management.model.dto.report.*;
import com.backend.pharmacy_management.model.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/report")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReportController {
    @Autowired
    IReportService reportService;

    @GetMapping("/{choice}/{startDate}/{endDate}")
    public ResponseEntity<List> getList(@PathVariable String choice, @PathVariable String startDate, @PathVariable String endDate) {
        switch (choice) {
            case "reportImportDetails":
                return new ResponseEntity<>(reportService.reportImportDetails(startDate, endDate), HttpStatus.OK);
            case "reportCancellationDetails":
                return new ResponseEntity<>(reportService.reportCancellationDetails(startDate, endDate), HttpStatus.OK);
            case "reportRefundExportDetails":
                return new ResponseEntity<>(reportService.reportRefundExportDetails(startDate, endDate), HttpStatus.OK);
            case "reportRetailDetails":
                return new ResponseEntity<>(reportService.reportRetailDetails(startDate, endDate), HttpStatus.OK);
            case "reportWholesaleDetails":
                return new ResponseEntity<>(reportService.reportWholesaleDetails(startDate, endDate), HttpStatus.OK);
            case "reportDetailsSoldByOrder":
                return new ResponseEntity<>(reportService.reportDetailsSoldByOrder(startDate, endDate), HttpStatus.OK);
            case "supplierList":
                return new ResponseEntity<>(reportService.supplierList(), HttpStatus.OK);
            case "reportOnMedicationBeingProvided":
                return new ResponseEntity<>(reportService.reportOnMedicationBeingProvided(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
