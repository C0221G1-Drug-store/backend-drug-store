package com.backend.pharmacy_management.model.service.report;

import com.backend.pharmacy_management.model.dto.report.*;

import java.util.List;

public interface IReportService {
<<<<<<< HEAD
<<<<<<< HEAD
    List<ReportDto> importDetails(String startDate, String endDate);
    List<ReportDto> cancellationDetails(String startDate, String endDate);
    List<ReportSellingDiary> sellingDiarys(String startDate, String endDate);
    List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds(String startDate, String endDate);
    List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires(String startDate, String endDate);
=======

    List<ReportImportDetails> reportImportDetails(String startDate, String endDate);

    List<ReportCancellationDetails> reportCancellationDetails(String startDate, String endDate);


    List<ReportRefundExportDetails> reportRefundExportDetails(String startDate, String endDate);


    List<ReportRetailDetails> reportRetailDetails(String startDate, String endDate);


    List<ReportWholesaleDetails> reportWholesaleDetails(String startDate, String endDate);

    List<ReportDetailsSoldByOrder> reportDetailsSoldByOrder(String startDate, String endDate);

    List<SupplierList> supplierList();

    List<ReportOnMedicationBeingProvided> reportOnMedicationBeingProvided();
    List<ReportSellingDiary> sellingDiarys(String startDate, String endDate);
    List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds();
    List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires();
>>>>>>> 145df7a2fcc28cf351761447fc57c9835c49588c
=======
    List<ReportImportDetails> reportImportDetails(String startDate, String endDate);
    List<ReportCancellationDetails> reportCancellationDetails(String startDate, String endDate);
    List<ReportRefundExportDetails> reportRefundExportDetails(String startDate, String endDate);
    List<ReportRetailDetails> reportRetailDetails(String startDate, String endDate);
    List<ReportWholesaleDetails> reportWholesaleDetails(String startDate, String endDate);
    List<ReportDetailsSoldByOrder> reportDetailsSoldByOrder(String startDate, String endDate);
    List<SupplierList> supplierList();
    List<ReportOnMedicationBeingProvided> reportOnMedicationBeingProvided();
    List<ReportSellingDiary> sellingDiarys(String startDate, String endDate);
    List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds();
    List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires();
>>>>>>> b2e2d8e09b0519b3757996dee14d6a9b38af8d9d
    List<ReportBestSellingDrug> bestSellingDrugs(String startDate, String endDate);
}
