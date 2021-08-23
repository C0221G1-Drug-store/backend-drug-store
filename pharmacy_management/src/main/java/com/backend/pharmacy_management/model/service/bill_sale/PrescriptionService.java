package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.repository.bill_sale.IPrescriptionRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService implements IPrescriptionService{
    @Autowired
    IPrescriptionRpository iPrescriptionRpository;
    @Override
    public List<Prescription> findAll() {
        return iPrescriptionRpository.findAll();
    }

    @Override
    public Prescription findById(int id) {
        return iPrescriptionRpository.findById(id);
    }

    @Override
    public List<Prescription> search(String fieldSearch, String valueSearch) {
//        return null;
        if (fieldSearch.equals("prescriptionName") ){
            return iPrescriptionRpository.findpres("%" + valueSearch + "%");
        }
        return iPrescriptionRpository.findBySign("%" + valueSearch + "%");

    }
}
