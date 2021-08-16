package com.backend.pharmacy_management.model.service.import_bill;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.repository.import_bill.IImportBillRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ImportBillService implements IImportBillService {
    private final IImportBillRepository importBillRepository;

    public ImportBillService(IImportBillRepository importBillRepository) {
        this.importBillRepository = importBillRepository;
    }

    @Override
    public Page<ImportBill> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<ImportBill> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ImportBill> findAllNormal() {
        return null;
    }

    @Override
    public void save(ImportBill importBill) {
        importBillRepository.save(importBill);
    }

    @Override
    public void remove(Long id) {

    }
}
