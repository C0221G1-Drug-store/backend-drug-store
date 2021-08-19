package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.DrugDto;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/drugs")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class DrugRestController {
    private final IDrugService drugService;

    public DrugRestController(IDrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public ResponseEntity<List<Drug>> getAll() {
        List<Drug> drugs = drugService.findAllNormal();
        if (drugs.isEmpty()) {
            return new ResponseEntity<List<Drug>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Drug> create(@Valid @RequestBody DrugDto drugDto) {
        Drug drug = new Drug();
        BeanUtils.copyProperties(drugDto, drug);
        this.drugService.save(drug);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Drug>> getDrugs(@PathVariable Long id) {
        Optional<Drug> drug = drugService.findById(id);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Drug> update(@Valid @RequestBody DrugDto drugDto, @PathVariable Long id) {
        Drug drug = new Drug();
        BeanUtils.copyProperties(drugDto, drug);
        drug.setDrugId(id);
        this.drugService.save(drug);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
