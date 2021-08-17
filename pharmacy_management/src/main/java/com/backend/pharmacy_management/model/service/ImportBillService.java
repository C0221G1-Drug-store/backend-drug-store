package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;

import java.util.List;

public interface ImportBillService {

    List<ImportBill> findByManufacturerId(Long id);
}
