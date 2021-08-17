package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExportBillRepository extends JpaRepository<ExportBill,Long> {
    @Query(value = "select export_bill_code from export_bill",nativeQuery  = true)
    List<String> getAllExportBillCode();
}
