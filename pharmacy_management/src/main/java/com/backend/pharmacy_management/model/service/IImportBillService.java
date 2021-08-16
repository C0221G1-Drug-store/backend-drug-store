package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;

import java.util.List;

public interface IImportBillService extends IGeneralService<ImportBill> {
    List<ImportBill>getAllImportBill(int index);
    List<ImportBill>getAllImportBillNotPagination();
    List<ImportBill>search(String importCode);
    List<ImportBill>searchBill(String importCode,String startDate,String endDate);
}
