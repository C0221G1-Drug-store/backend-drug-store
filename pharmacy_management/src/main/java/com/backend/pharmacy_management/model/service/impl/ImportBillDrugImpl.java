package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.repository.ImportBillDrugRepository;
import com.backend.pharmacy_management.model.service.ImportBillDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImportBillDrugImpl implements ImportBillDrugService {
    @Autowired
    private ImportBillDrugRepository importBillDetailRepository;

    @Override
    public List<ImportBillDrug> findAllImportBill() {
        return this.importBillDetailRepository.getAll();
    }

    @Override
    public ImportBillDrug findDrugByid(Long id) {
        return this.importBillDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<ImportBillDrug> getAllImportBillDrugByManufacuterId(Long id) {
        return this.importBillDetailRepository.getAllImportBillDrugByManufacuterId(id);
    }


}
