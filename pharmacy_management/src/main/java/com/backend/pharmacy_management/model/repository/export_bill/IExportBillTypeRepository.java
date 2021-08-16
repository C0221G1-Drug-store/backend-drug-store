package com.backend.pharmacy_management.model.repository.export_bill;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExportBillTypeRepository extends JpaRepository<ExportBillType,Long> {
}
