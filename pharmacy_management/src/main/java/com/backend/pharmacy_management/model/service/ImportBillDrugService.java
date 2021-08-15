package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImportBillDrugService {
    List<ImportBillDrug> findAllImportBill();
}
