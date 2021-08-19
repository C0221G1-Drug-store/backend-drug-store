package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;

import java.util.List;
import java.util.Optional;

public interface IDrugService  {
    Optional<Drug> findById(Long id);
    List<Drug> findAllNormal();
    void save(Drug drug);
    void remove(Long id);
}
