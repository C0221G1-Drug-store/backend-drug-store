package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import com.backend.pharmacy_management.model.service.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl implements IDrugService {
    @Autowired
    private IDrugRepository drugRepository;

    @Override
    public void updateAmountDrug(Long id, Integer amount) {
        Drug drug = this.findById(id);
        if(drug != null){
            drug.setDrugAmount(drug.getDrugAmount() - amount);
        }
        this.drugRepository.save(drug);
    }

    @Override
    public Drug findById(Long id) {
        return this.drugRepository.findById(id).orElse(null);
    }
}
