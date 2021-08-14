package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.dto.DetailReportDto;

import java.util.List;

public interface IDetailReportService {
    List<DetailReportDto> reportImportDetails(String startDate, String endDate);
}
