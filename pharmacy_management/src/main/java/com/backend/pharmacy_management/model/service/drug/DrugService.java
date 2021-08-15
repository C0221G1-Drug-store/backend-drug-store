package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DrugService implements IDrugService {
    @Autowired
    private IDrugRepository iDrugRepository;
    @Override
    public Page<Drug> findAllDrugs(Pageable pageable) {
        return iDrugRepository.findAllDrugs(pageable);
    }

    @Override
    public Iterable<Drug> findAll() {
        return iDrugRepository.findAll();
    }
}
