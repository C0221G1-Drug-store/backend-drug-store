package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.backend.pharmacy_management.model.service.IIndicativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    @GetMapping(value = "/drugs")
//    public ResponseEntity<List<Drug>> showCategory() {
//        List<Drug> drugList = (List<Drug>) categoryService.findAll();
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
    @PostMapping(value = "/indicative-create")
    public ResponseEntity saveIndicative(@RequestBody Indicative indicative) {
        return new ResponseEntity<>(iIndicativeService.save(indicative), HttpStatus.CREATED);
    }

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
