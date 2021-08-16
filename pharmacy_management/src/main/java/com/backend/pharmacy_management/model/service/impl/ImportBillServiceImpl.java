package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.repository.IImportBillRepository;
import com.backend.pharmacy_management.model.service.IImportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImportBillServiceImpl implements IImportBillService {
    @Autowired
    IImportBillRepository importBillRepository;

    @Override
    public List<ImportBill> findAll() {
        return importBillRepository.findAll();
    }

    @Override
    public Optional<ImportBill> findById(Long id) {
        return importBillRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        importBillRepository.deleteById(id);
    }

    @Override
    public List<ImportBill> getAllImportBill(int index) {
        return importBillRepository.getAllImportBill(index);
    }

    @Override
    public List<ImportBill> getAllImportBillNotPagination() {
        return importBillRepository.getAllImportBillNotPaging();
    }

    @Override
    public List<ImportBill> search(String importCode) {
        return importBillRepository.search("%" + importCode + "%");
    }

    @Override
    public List<ImportBill> searchBill(String importCode, String startDate, String endDate) {
        return importBillRepository.searchBill("%" + importCode + "%", startDate, endDate);
    }

}
