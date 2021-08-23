package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.drug.Drug;

import java.util.List;

public interface IDrugService {
    List<Drug> findAll();
}
