package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDrugService {
    Page<Drug> findAllDrugs(Pageable pageable);
    Iterable<Drug> findAll();
    Drug saveDrug(Drug drug);
}
