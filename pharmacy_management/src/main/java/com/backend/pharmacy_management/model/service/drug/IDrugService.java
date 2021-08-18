package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;

import java.util.List;
import java.util.Optional;

public interface IDrugService {

    List<DrugDTO> findAllDrugs(int index);
    Iterable<Drug> findAll();
    Drug saveDrug(Drug drug);

    List<ListDrugDTO> findAllDrugsPagination(int index);
    List<ListDrugDTO> findAllDrugsSearch(String field, String sign, String input, String index);
    List<ListDrugDTO> findAllDrugsSearchNotPagination(String field, String sign, String input);
    List<ListDrugDTO> findAllDrugsLikePagination(String field, String input, String index);
    List<ListDrugDTO> findAllDrugsNotPagination();

  
   void deleteDrugById(Long id);
    DrugDTO findDrugById(Long id);
}
