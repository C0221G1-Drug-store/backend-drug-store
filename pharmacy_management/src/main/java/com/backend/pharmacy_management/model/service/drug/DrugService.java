package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.drug.DrugDTO;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService implements IDrugService {
    @Autowired
    private IDrugRepository iDrugRepository;
    @Override
    public List<DrugDTO> findAllDrugs(int index) {
        return iDrugRepository.findAllDrugs(index);
    }

    @Override
    public Iterable<Drug> findAll() {
        return iDrugRepository.findAll();
    }

    @Override
    public Drug saveDrug(Drug drug) {
        return iDrugRepository.save(drug);
    }
}
