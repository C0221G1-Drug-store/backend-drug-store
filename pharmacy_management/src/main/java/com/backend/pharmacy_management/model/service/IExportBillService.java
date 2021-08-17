package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;

import java.util.List;

public interface IExportBillService {
    void createExportBill(ExportBill exportBill);
    void createExportBillDetail(ExportBillDetail exportBillDetail);
    List<ExportBillType> getListExportBillTye();
    String createCodeExportBill();
    List<ExportBill> getAll();
}
