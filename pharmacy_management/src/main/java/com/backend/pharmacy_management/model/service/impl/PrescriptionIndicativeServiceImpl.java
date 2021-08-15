package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.indicative_prescription.PrescriptionIndicative;
import com.backend.pharmacy_management.model.repository.IPrescriptionIndicativeRepository;
import com.backend.pharmacy_management.model.service.IPrescriptionIndicativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PrescriptionIndicativeServiceImpl implements IPrescriptionIndicativeService {
    @Autowired
    private IPrescriptionIndicativeRepository iPrescriptionIndicativeRepository;

    @Override
    public Iterable findAll() {
        return this.iPrescriptionIndicativeRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return this.iPrescriptionIndicativeRepository.findById(id);
    }

    @Override
    public PrescriptionIndicative save(PrescriptionIndicative prescriptionIndicative) {
       return this.iPrescriptionIndicativeRepository.save(prescriptionIndicative);
    }


    @Override
    public void remove(Long id) {
        this.iPrescriptionIndicativeRepository.deleteById(id);
    }
}
