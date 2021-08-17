package com.backend.pharmacy_management.model.service;

import java.util.List;

public interface ExportBillService {
    String createExportBillRefundCode();
    List<String> getAllExportBillCode();
}
