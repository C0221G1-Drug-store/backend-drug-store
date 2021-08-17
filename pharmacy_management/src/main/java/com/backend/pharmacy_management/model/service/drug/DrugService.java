package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<ListDrugDTO> searchDrugs(String searchTerm) {
        return iDrugRepository.searchDrugs(searchTerm);
    }

    @Override
    public List<ListDrugDTO> findDrugByGroup(String drugGroupName) {
        return iDrugRepository.findDrugByGroup(drugGroupName);
    }

    @Override
    public DrugDTO findDrugById(Long id) {
        return iDrugRepository.findDrugById(id);
    }
}
