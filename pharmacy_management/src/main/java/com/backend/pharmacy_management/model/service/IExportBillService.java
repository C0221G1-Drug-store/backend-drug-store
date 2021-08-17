package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExportBillService {
    Page<ExportBill> findAll(Pageable pageable);

    ExportBill findById(long id);

    Page<ExportBill> findByFields(String field1, String field2, String field3, String field4, Long typeId, Pageable pageable);

    void delete(long id);
}
