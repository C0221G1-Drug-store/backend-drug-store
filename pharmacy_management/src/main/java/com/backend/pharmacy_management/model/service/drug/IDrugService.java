package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDrugService {
    List<Drug> findAll();
    Page<Drug> findAllDrugs(Pageable pageable);
    List<Drug> searchDrugs(String search);
    List<Drug> findDrugByGroup(Long drugGroupId);
}
