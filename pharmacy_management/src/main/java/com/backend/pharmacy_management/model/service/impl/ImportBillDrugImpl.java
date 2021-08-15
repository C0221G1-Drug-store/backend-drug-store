package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.repository.ImportBillDetailRepository;
import com.backend.pharmacy_management.model.service.ImportBillDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImportBillDrugImpl implements ImportBillDrugService {
    @Autowired
    private ImportBillDetailRepository importBillDetailRepository;

    @Override
    public List<ImportBillDrug> findAllImportBill() {
        return this.importBillDetailRepository.findAll();
    }
}
