package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.repository.drug.IDrugGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugGroupService implements IDrugGroupService{
    @Autowired
    private IDrugGroupRepository iDrugGroupRepository;

    @Override
    public List<DrugGroup> findAll() {
        return (List<DrugGroup>) iDrugGroupRepository.findAll();
    }
}
