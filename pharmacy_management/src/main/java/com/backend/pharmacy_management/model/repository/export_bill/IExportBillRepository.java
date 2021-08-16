package com.backend.pharmacy_management.model.repository.export_bill;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExportBillRepository extends JpaRepository<ExportBill, Long> {
    @Query(value = "select export_bill_code from export_bill", nativeQuery = true)
    List<String> getListCode();
}
