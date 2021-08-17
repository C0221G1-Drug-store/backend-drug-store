package com.backend.pharmacy_management.controller.prescription_indicative;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.service.prescription_indicative.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlAnyAttribute;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "prescriptions")
@CrossOrigin(origins = "http://localhost:4200/")
public class PrescriptionController {
    @Autowired
    private IPrescriptionService iPrescriptionService;


    @GetMapping(value = "prescription-list")
    public ResponseEntity<Page<Prescription>> showList(@RequestParam Integer page) {
        Page<Prescription> prescriptionList =  iPrescriptionService.getAllPrescriptionList(PageRequest.of(page,5));
        if (prescriptionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
    }


    @GetMapping(value = "prescription-list")
    public ResponseEntity<Page<Prescription>> showList1(@RequestParam Optional<String> prescriptionName,
                                                       @RequestParam Optional<String> prescriptionCode,
                                                       @RequestParam Optional<String> object,
                                                       @RequestParam Optional<String> symptom,
                                                       @RequestParam Integer page,
                                                       @RequestParam Optional<String> sortBy) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.ASC, sortBy.orElse("prescription_id"));
        String name = "";
        if (prescriptionName.isPresent()) {
            name = prescriptionName.get();
        }
        String code = "";
        if (prescriptionCode.isPresent()) {
            code = prescriptionCode.get();
        }
        String obj = "";
        if (object.isPresent()) {
            obj = object.get();
        }
        String sym = "";
        if (symptom.isPresent()) {
            sym = symptom.get();
        }

        Page<Prescription> prescriptionList = iPrescriptionService.searchPrescription(name, code, obj, sym,pageable);
        if (prescriptionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
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

    @GetMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> findPrescriptionById(@PathVariable Long id) {
        Optional<Prescription> prescriptionOptional = iPrescriptionService.findById(id);
        if (!prescriptionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescriptionOptional.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/prescription-create")
    public ResponseEntity savePrescription(@RequestBody Prescription prescription) {

        Iterable<Prescription> prescriptions=iPrescriptionService.findAll();


        return new ResponseEntity<>(iPrescriptionService.save(prescription), HttpStatus.CREATED);
    }


    @PutMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
        Optional<Prescription> prescriptionOptional = iPrescriptionService.findById(id);
        if (!prescriptionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        product.setId(productOptional.get().getId());
//        prescription.setPrescriptionId(prescriptionOptional.get().getPrescriptionId());
        return new ResponseEntity<>(iPrescriptionService.save(prescription), HttpStatus.OK);
    }

    @DeleteMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable Long id) {
        Optional<Prescription> prescriptionOptional = iPrescriptionService.findById(id);
        if (!prescriptionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        iPrescriptionService.remove(id);
        return new ResponseEntity<>(prescriptionOptional.get(), HttpStatus.NO_CONTENT);
    }
}
