package com.backend.pharmacy_management.model.service.report;

import com.backend.pharmacy_management.model.dto.report.ReportDto;

import java.util.List;

public interface IReportService {
    List<ReportDto> importDetails(String startDate, String endDate);
    List<ReportDto> cancellationDetails(String startDate, String endDate);
}
