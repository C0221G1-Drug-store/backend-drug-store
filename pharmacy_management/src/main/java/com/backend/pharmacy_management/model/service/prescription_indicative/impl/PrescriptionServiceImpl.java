package com.backend.pharmacy_management.model.service.prescription_indicative.impl;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.repository.prescription_indicative.IPrescriptionRepository;
import com.backend.pharmacy_management.model.service.prescription_indicative.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements IPrescriptionService {
    @Autowired
    private IPrescriptionRepository prescriptionRepository;

    @Override
    public Iterable<Prescription> findAll() {
        return this.prescriptionRepository.findAll();
    }

    @Override
    public Optional<Prescription> findById(Long id) {
        return this.prescriptionRepository.findById(id);
    }

    @Override
    public Prescription save(Prescription prescription) {
        return this.prescriptionRepository.save(prescription);
    }

    @Override
    public void remove(Long id) {
        this.prescriptionRepository.deleteById(id);
    }

    @Override
    public Page<Prescription> getAllPrescriptionList(Pageable pageable) {
        return this.prescriptionRepository.findAll(pageable);
    }

    @Override
    public Page<Prescription> searchPrescription(String prescriptionName, String prescriptionCode, String object, String symptom, Pageable pageable) {
        return this.prescriptionRepository.findByPrescriptionFilter(prescriptionName,prescriptionCode,object,symptom,pageable);
    }
}
