package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.DetailReportDto;
import com.backend.pharmacy_management.model.service.IDetailReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/report")
@CrossOrigin(origins = "http://localhost:4200/")
public class ImportBillController {
//    @Autowired
//    IDetailReportService service;
//    @GetMapping("/import-details/{startDate}/{endDate}")
//    public ResponseEntity<List<DetailReportDto>> reportImportDetails(@PathVariable String startDate, @PathVariable String endDate) {
//        List<DetailReportDto> reportImportDetailsList = service.reportImportDetails(startDate, endDate);
//        return new ResponseEntity<List<DetailReportDto>>(reportImportDetailsList, HttpStatus.OK);
//    }
}
