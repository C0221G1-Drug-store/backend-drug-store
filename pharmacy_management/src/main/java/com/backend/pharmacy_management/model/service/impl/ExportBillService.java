package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.repository.ExportBillRepository;
import com.backend.pharmacy_management.model.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExportBillService implements IExportBillService {
    @Autowired
    ExportBillRepository exportBillRepository;

    public Page<ExportBill> findAll(Pageable pageable) {
        return this.exportBillRepository.findAll(pageable);
    }

    public ExportBill findById(long id) {
        return this.exportBillRepository.findById(id).orElse(null);
    }

    @Override
    public Page<ExportBill> findByFields(String field1, String field2, String field3, String field4, Long typeId, Pageable pageable) {
        return this.exportBillRepository.findByTimeFields(field1, field2, field3, field4, typeId, pageable);
    }

    public void delete(long id) {
        this.exportBillRepository.deleteById(id);
    }
}
