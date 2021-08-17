package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;

import java.util.List;

public interface IDrugService {
    List<ListDrugDTO> findAllDrugsPagination(int index);
    List<ListDrugDTO> findAllDrugsNotPagination();
    List<ListDrugDTO> searchDrugs(String searchTerm);
    List<ListDrugDTO> findDrugByGroup(String drugGroupName);
    DrugDTO findDrugById(Long id);
    DrugDTO findDrugByIdClient(Long id);
}
