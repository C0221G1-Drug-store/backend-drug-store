package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private IDrugService drugService;
//    @GetMapping
//    public ResponseEntity<Page<Drug>> finAllDrugs(@PageableDefault(value = 3) Pageable pageable) {
//        Page<Drug> drugs = (Page<Drug>) drugService.findAllDrugs(pageable);
//        if (drugs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(drugs, HttpStatus.OK);
//    }
//    public ResponseEntity<Page<Drug>> finAllDrugs(@PageableDefault(value = 3) Pageable pageable) {
//        Page<Drug> drugs = (Page<Drug>) drugService.findAllDrugs(pageable);
//        if (drugs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(drugs, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<Drug> saveDrug(@RequestBody Drug drug){
        return new ResponseEntity<>(drugService.saveDrug(drug),HttpStatus.CREATED);
    }
}
  