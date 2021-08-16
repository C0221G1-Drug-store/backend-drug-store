package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
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
    public List<Drug> findAll() {
        return (List<Drug>) iDrugRepository.findAll();
    }

    @Override
    public Page<Drug> findAllDrugs(Pageable pageable) {
        return iDrugRepository.findAllDrugs(pageable);
    }

    @Override
    public List<Drug> searchDrugs(String search) {
        return iDrugRepository.searchDrugs(search);
    }

    @Override
    public List<Drug> findDrugByGroup(Long drugGroupId) {
        return iDrugRepository.findDrugByGroup(drugGroupId);
    }
}
