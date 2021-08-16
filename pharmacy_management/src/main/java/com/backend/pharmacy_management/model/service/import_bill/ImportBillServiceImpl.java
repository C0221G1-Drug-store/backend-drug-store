package com.backend.pharmacy_management.model.service.import_bill;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.repository.import_bill_payment.IImportBillDrugRepository;
import com.backend.pharmacy_management.model.service.IImportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportBillServiceImpl implements IImportBillService {
    @Autowired
    private IImportBillDrugRepository importBillDrugRepository;
    @Override
    public List<ImportBillDrug> getListDrug() {
        return this.importBillDrugRepository.getAll();
    }

    @Override
    public ImportBillDrug findById(Long id) {
        return this.importBillDrugRepository.findById(id).orElse(null);
    }

    @Override
    public void updateDrugImportBill(Long id) {
        ImportBillDrug importBillDrug = this.findById(id);
        importBillDrug.setFlag(false);
        this.importBillDrugRepository.save(importBillDrug);
    }
}
