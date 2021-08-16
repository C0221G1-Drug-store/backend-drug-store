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
    public ResponseEntity<List> getList(@PathVariable String choice, @PathVariable Optional<String> startDate, @PathVariable Optional<String> endDate) {
        switch (choice) {
            case "importDetails":
                List<ReportDto> reportDtoList;
                reportDtoList = reportService.importDetails(startDate.orElse(""), endDate.orElse(""));
                return new ResponseEntity<>(reportDtoList, HttpStatus.OK);
            case "sellingDiarys":
                List<ReportSellingDiary> sellingDiaryList;
                sellingDiaryList = reportService.sellingDiarys(startDate.orElse(""), endDate.orElse(""));
                return new ResponseEntity<>(sellingDiaryList, HttpStatus.OK);
            case "medicinesNeedToBeImporteds":
                List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImportedList;
                medicinesNeedToBeImportedList = reportService.medicinesNeedToBeImporteds(startDate.orElse(""), endDate.orElse(""));
                return new ResponseEntity<>(medicinesNeedToBeImportedList, HttpStatus.OK);
            case "theDrugIsAboutToExpires":
                List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpireList;
                theDrugIsAboutToExpireList = reportService.theDrugIsAboutToExpires(startDate.orElse(""), endDate.orElse(""));
                return new ResponseEntity<>(theDrugIsAboutToExpireList, HttpStatus.OK);
            case "bestSellingDrugs":
                List<ReportBestSellingDrug> bestSellingDrugList = reportService.bestSellingDrugs(startDate.orElse(""), endDate.orElse(""));
                return new ResponseEntity<>(bestSellingDrugList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
