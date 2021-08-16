package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.drug.DrugDTO;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======

import java.util.List;
>>>>>>> f7d6a41d710ac3f5ec8d92481a36f9da7ef7272d

@CrossOrigin
@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private IDrugService drugService;
<<<<<<< HEAD
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
=======
    @GetMapping
    public ResponseEntity<List<DrugDTO>> finAllDrugs(@RequestParam int index) {
        List<DrugDTO> drugs = (List<DrugDTO>) drugService.findAllDrugs(index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
>>>>>>> f7d6a41d710ac3f5ec8d92481a36f9da7ef7272d
    }
}
  