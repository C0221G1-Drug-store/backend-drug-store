package com.backend.pharmacy_management.model.repository.import_bill_payment;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImportBillRepository extends JpaRepository<ImportBill, Long> {
}
