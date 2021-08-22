package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import com.backend.pharmacy_management.model.repository.drug.IDrugImageDetailRepository;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService implements IDrugService {
    @Autowired
    private IDrugRepository iDrugRepository;
    @Autowired
    private IDrugImageDetailRepository iDrugImageDetailRepository;




    public List<ListDrugDTO> findAllDrugsPagination(int index) {
        return iDrugRepository.findAllDrugsPagination(index);

    }

    @Override
    public List<ListDrugDTO> findAllDrugsSearch(String field, String sign, String input, String index) {
        return iDrugRepository.findAllDrugsSearch(field, sign, input, index);
    }

    @Override
    public List<ListDrugDTO> findAllDrugsSearchNotPagination(String field, String sign, String input) {
        return iDrugRepository.findAllDrugsSearchNotPagination(field, sign, input);
    }



    @Override
    public List<ListDrugDTO> findAllDrugsNotPagination() {
        return iDrugRepository.findAllDrugsNotPagination();
    }

//    @Override
//    public void saveDrug(Drug drug) {
//         iDrugRepository.createDrug(drug.getDrugCode(),drug.getDrugName(), drug.getActiveElement(),
//                drug.getUnit(), drug.getConversionUnit(), drug.getConversionRate(), drug.getWholesaleProfitRate(),
//                drug.getRetailProfitRate(), drug.getDrugFaculty(), drug.getManufacturer(), drug.getOrigin(),
//                drug.getNote(), drug.getFlag(), drug.getDrugSideEffect());
//    }


    public void deleteDrugById(Long id) {
        iDrugRepository.deleteDrugById(id);
    }

    @Override
    public DrugDTO findDrugById(Long id) {
        return iDrugRepository.findDrugById(id);
    }

    @Override
    public Drug findById(Long id) {
        return iDrugRepository.findById(id).orElse(null);
    }

//    @Override
//    public void saveDrugImage(DrugImageDetail drugImageDetail) {
//        iDrugImageDetailRepository.createDrugImageDetail(drugImageDetail.getDrugImageDetailUrl());
//    }

    @Override
    public DrugImageDetail saveDrugImage(DrugImageDetail drugImageDetail) {
        return iDrugImageDetailRepository.save(drugImageDetail);
    }

    @Override
    public Drug saveDrug(Drug drug) {
        return iDrugRepository.save(drug);
    }
}
