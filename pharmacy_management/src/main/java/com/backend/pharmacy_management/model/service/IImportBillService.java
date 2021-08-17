package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;

import java.util.List;

public interface IImportBillService {
    List<ImportBillDrug> getListDrug();
    ImportBillDrug findById(Long id);
    void updateDrugImportBill(Long id);
}
