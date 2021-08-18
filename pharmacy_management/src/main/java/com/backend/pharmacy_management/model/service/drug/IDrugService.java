package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;

import java.util.List;
import java.util.Optional;

public interface IDrugService {

    List<DrugDTO> findAllDrugs(int index);
    Iterable<Drug> findAll();
    Drug saveDrug(Drug drug);

    List<ListDrugDTO> findAllDrugsPagination(int index);
    List<ListDrugDTO> findAllDrugsNotPagination();

  
   void deleteDrugById(Long id);
    DrugDTO findDrugById(Long id);
    Drug findById(Long id);
    DrugImageDetail saveDrugImage(DrugImageDetail drugImageDetail);

}
