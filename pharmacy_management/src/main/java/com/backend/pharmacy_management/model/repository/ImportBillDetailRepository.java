package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImportBillDetailRepository extends JpaRepository<ImportBillDrug,Long> {


}
