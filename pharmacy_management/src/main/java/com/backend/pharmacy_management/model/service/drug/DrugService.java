package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService implements IDrugService {
    @Autowired
    private IDrugRepository iDrugRepository;

    @Override
    public List<ListDrugDTO> findAllDrugsPagination(int index) {
        return iDrugRepository.findAllDrugsPagination(index);
    }

    @Override
    public List<ListDrugDTO> findAllDrugsNotPagination() {
        return iDrugRepository.findAllDrugsNotPagination();
    }

    @Override
    public void deleteDrugById(Long id) {
        iDrugRepository.deleteDrugById(id);
    }

    @Override
    public DrugDTO findDrugById(Long id) {
        return iDrugRepository.findDrugById(id);
    }
}
