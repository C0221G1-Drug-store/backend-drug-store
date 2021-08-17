package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.drug.Drug;

import java.util.List;

public interface IDrugService {
    void updateAmountDrug(Long id, Integer amount);
    Drug findById(Long id);
}
