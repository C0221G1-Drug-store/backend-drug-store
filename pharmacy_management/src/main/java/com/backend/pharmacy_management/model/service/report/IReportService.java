package com.backend.pharmacy_management.model.service.report;

import com.backend.pharmacy_management.model.dto.report.*;

import java.util.List;

public interface IReportService {
    List<ReportDto> importDetails(String startDate, String endDate);
    List<ReportDto> cancellationDetails(String startDate, String endDate);
    List<ReportSellingDiary> sellingDiarys(String startDate, String endDate);
    List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds(String startDate, String endDate);
    List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires(String startDate, String endDate);
    List<ReportBestSellingDrug> bestSellingDrugs(String startDate, String endDate);
}
