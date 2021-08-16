package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.repository.bill_sale.IDrugOfBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DrugOfBillService implements IDrugOfBillService {
    @Autowired
    IDrugOfBillRepository iDrugOfBillRepository;

    @Override
    public List<DrugOfBill> findAllDrugOfBillByBillSaleId(Long id) {
        return iDrugOfBillRepository.findAllDrugOfBillByBillSaleId(id);
    }

    @Override
    public void save(DrugOfBill drugOfBill) {
         iDrugOfBillRepository.save(drugOfBill);
    }

    @Override
    public void saveList(List<DrugOfBill> drugOfBillList) {
        iDrugOfBillRepository.saveAll(drugOfBillList);
    }

    @Override
    public void remove(Long id) {
        iDrugOfBillRepository.deleteById(id);
    }
}
