package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.repository.bill_sale.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService implements IDrugService{
    @Autowired
    IDrugRepository iDrugRepository;
    @Override
    public List<Drug> findAll() {
        return iDrugRepository.findAll();
    }
}
