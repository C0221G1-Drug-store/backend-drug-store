package com.backend.pharmacy_management.model.repository.import_bill;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImportBillDrugRepository extends JpaRepository<ImportBillDrug,Long> {
}
