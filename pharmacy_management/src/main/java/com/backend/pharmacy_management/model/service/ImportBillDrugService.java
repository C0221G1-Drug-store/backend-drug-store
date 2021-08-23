package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;

import java.util.List;

public interface ImportBillDrugService {
    List<ImportBillDrug> findAllImportBill();

    ImportBillDrug findDrugByid(Long id);

    List<ImportBillDrug> getAllImportBillDrugByManufacuterId(Long id);

    void updateImportBillDrug(Long id);

}
