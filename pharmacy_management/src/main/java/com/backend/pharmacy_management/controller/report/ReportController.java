package com.backend.pharmacy_management.controller.report;

import com.backend.pharmacy_management.model.dto.report.ReportDto;
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
    public ResponseEntity<List<ReportDto>> getList(@PathVariable String choice, @PathVariable Optional<String> startDate, @PathVariable Optional<String> endDate) {
        List<ReportDto> reportDtoList;
        switch (choice) {
            case "importDetails":
                reportDtoList = reportService.importDetails(startDate.orElse(""), endDate.orElse(""));
                return new ResponseEntity<>(reportDtoList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
