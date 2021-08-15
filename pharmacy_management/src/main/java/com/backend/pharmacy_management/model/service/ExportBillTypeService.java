package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExportBillTypeService {
    List<ExportBillType> findAllExportBillType();
}
