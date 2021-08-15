package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.service.IIndicativeService;
import com.backend.pharmacy_management.model.service.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "indicatives")
@CrossOrigin(origins = "http://localhost:4200/")
public class IndicativeController {
    @Autowired
    private IIndicativeService iIndicativeService;


    @GetMapping(value = "indicative-list")
    public ResponseEntity<List<Indicative>> showList() {
        List<Indicative> indicativeList = (List<Indicative>) iIndicativeService.findAll();
        if (indicativeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(indicativeList, HttpStatus.OK);
    }
//
//    @GetMapping(value = "/categories")
//    public ResponseEntity<List<Category>> showCategory() {
//        List<Category> categoryList = (List<Category>) categoryService.findAll();
//        if (categoryList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(categoryList, HttpStatus.OK);
//    }

//    @GetMapping("/prescriptions/{id}")
//    public ResponseEntity<Prescription> findPrescriptionById(@PathVariable Long id) {
//        Optional<Prescription> prescriptionOptional = iPrescriptionService.findById(id);
//        if (!prescriptionOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(prescriptionOptional.get(), HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/create")
//    public ResponseEntity savePrescription(@RequestBody Prescription prescription) {
//        return new ResponseEntity<>(iPrescriptionService.save(prescription), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/prescriptions/{id}")
//    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
//        Optional<Prescription> prescriptionOptional = iPrescriptionService.findById(id);
//        if (!prescriptionOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
////        product.setId(productOptional.get().getId());
//        prescription.setPrescriptionId(prescriptionOptional.get().getPrescriptionId());
//        return new ResponseEntity<>(iPrescriptionService.save(prescription), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/prescriptions/{id}")
//    public ResponseEntity<Prescription> deletePrescription(@PathVariable Long id) {
//        Optional<Prescription> prescriptionOptional = iPrescriptionService.findById(id);
//        if (!prescriptionOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        iPrescriptionService.remove(id);
//        return new ResponseEntity<>(prescriptionOptional.get(), HttpStatus.NO_CONTENT);
//    }
}
