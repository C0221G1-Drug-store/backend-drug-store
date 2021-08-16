package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.repository.DrugRepository;
import com.backend.pharmacy_management.model.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugImpl implements DrugService {
    @Autowired
    private DrugRepository drugRepository;

    @Override
    public List<Drug> findAllDrug() {
        return drugRepository.findAll();
    }
}
