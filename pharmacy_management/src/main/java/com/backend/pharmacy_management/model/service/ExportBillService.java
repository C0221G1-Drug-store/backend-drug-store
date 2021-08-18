package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;

import java.util.List;

public interface ExportBillService {
    void createExportBill(ExportBill exportBill);
    void createExportBillDetail(ExportBillDetail exportBillDetail);
    String createExportBillRefundCode();
    List<String> getAllExportBillCode();
}
