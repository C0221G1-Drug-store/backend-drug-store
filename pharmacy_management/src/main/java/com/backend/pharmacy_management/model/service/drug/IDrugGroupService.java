package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;

import java.util.List;

public interface IDrugGroupService {
    List<DrugGroup> findAll();
}
