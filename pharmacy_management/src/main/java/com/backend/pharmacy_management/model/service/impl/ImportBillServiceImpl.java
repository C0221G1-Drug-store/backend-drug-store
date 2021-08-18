package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.repository.ImportBillRepository;
import com.backend.pharmacy_management.model.service.ImportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImportBillServiceImpl implements ImportBillService {

    @Autowired
    private ImportBillRepository importBillRepository;

    @Override
    public List<ImportBill> findByManufacturerId(Long id) {
        return importBillRepository.findByIdManufacturer(id);
    }
}
