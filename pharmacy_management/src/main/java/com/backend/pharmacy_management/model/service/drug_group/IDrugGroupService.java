package com.backend.pharmacy_management.model.service.drug_group;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;

import java.util.List;

public interface IDrugGroupService {
    List<DrugGroup> findAllDrugGroup();
}
