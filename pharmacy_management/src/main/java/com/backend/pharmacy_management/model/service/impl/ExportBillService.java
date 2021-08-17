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
    public Page<ExportBill> findByFields(String dateCreate, String toDate, String timeCreate, String toTime, long typeId, Pageable pageable) {
        if (dateCreate == toDate && dateCreate == "2021-01-01") {
            return this.exportBillRepository.findByTimeFields(timeCreate, toTime, typeId, pageable);
        } else if (timeCreate == toTime && timeCreate == "00:00" ) {
            return this.exportBillRepository.findByDateFields(dateCreate, toDate, typeId, pageable);
        }
        return this.exportBillRepository.findBy4Fields(dateCreate, toDate, timeCreate, toTime, typeId, pageable);
    }

    public void delete(long id) {
        this.exportBillRepository.deleteById(id);
    }
}
