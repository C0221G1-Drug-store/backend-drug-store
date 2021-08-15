package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportBillDetailRepository extends JpaRepository<ImportBillDrug,Long> {
}
