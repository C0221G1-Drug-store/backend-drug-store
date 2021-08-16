package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DrugService implements IDrugService{
    @Autowired
    IDrugRepository drugRepository;

    @Override
    public Page<Drug> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Drug> findById(Long id) {
        return drugRepository.findById(id);
    }

    @Override
    public List<Drug> findAllNormal() {
        return drugRepository.findAll();
    }

    @Override
    public void save(Drug drug) {

    }

    @Override
    public void remove(Long id) {

    }
}
