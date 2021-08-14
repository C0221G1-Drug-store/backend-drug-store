package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public interface IExportBillService {
    List<ExportBill> findAll();

    ExportBill findById(long id);

    List<ExportBill> findByFields();

    void delete(long id);
}
