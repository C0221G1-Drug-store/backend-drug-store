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

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private IDrugService drugService;
    @GetMapping(value = {"/list-pageable"})
    public ResponseEntity<Page<Drug>> finAllDrugs(@PageableDefault(value = 3) Pageable pageable) {
        Page<Drug> drugs = (Page<Drug>) drugService.findAllDrugs(pageable);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Drug>> getAllDrug() {
        List<Drug> drugList = this.drugService.findAll();

        if (drugList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(drugList,HttpStatus.OK);
    }


    @GetMapping(value = {"/search/{search}"})
    public ResponseEntity<List<Drug>> searchDrugs(@PathVariable String search) {
        List<Drug> drugList = this.drugService.searchDrugs(search);

        if (drugList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(drugList,HttpStatus.OK);
    }

    @GetMapping(value = {"drug-group/{drugGroupId}"})
    public ResponseEntity<List<Drug>> findDrugByGroup(@PathVariable Long drugGroupId) {
        List<Drug> drugList = this.drugService.findDrugByGroup(drugGroupId);

        if (drugList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(drugList,HttpStatus.OK);
    }
}
  