package com.backend.pharmacy_management.model.repository.import_bill_payment;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImportBillDrugRepository extends JpaRepository<ImportBillDrug, Long> {
    @Query(value = "select * from import_bill_drug d where d.import_amount > 0 && d.flag=1", nativeQuery = true)
    List<ImportBillDrug> getAll();
}
