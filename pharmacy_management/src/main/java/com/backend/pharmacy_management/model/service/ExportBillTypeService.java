package com.backend.pharmacy_management.model.service;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;


import java.util.List;

public interface ExportBillTypeService {
    List<ExportBillType> findAllExportBillType();
}
