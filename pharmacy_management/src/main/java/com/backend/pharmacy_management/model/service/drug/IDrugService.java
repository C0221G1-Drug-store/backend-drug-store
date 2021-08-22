package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;

import java.util.List;


public interface IDrugService {
    Drug saveDrug(Drug drug);
//    void saveDrug(Drug drug);
    List<ListDrugDTO> findAllDrugsPagination(int index);
    List<ListDrugDTO> findAllDrugsNotPagination();
    void deleteDrugById(Long id);
    DrugDTO findDrugById(Long id);
    Drug findById(Long id);
//    void saveDrugImage(DrugImageDetail drugImageDetail);
    DrugImageDetail saveDrugImage(DrugImageDetail drugImageDetail);
}
