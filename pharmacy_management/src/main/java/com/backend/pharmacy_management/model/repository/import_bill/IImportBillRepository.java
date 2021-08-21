package com.backend.pharmacy_management.model.repository.import_bill;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImportBillRepository extends JpaRepository<ImportBill,Long> {
    @Query(value = "select * from import_bill", nativeQuery = true)
     List<ImportBill> getListNormals();
}
