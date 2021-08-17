package com.backend.pharmacy_management.model.repository.export_bill;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExportBillDetailRepository extends JpaRepository<ExportBillDetail, Long> {
}
