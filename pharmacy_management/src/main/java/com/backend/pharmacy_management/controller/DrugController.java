package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private IDrugService drugService;
    @GetMapping
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsPagination(@RequestParam int index) {
        List<ListDrugDTO> drugs = (List<ListDrugDTO>) drugService.findAllDrugsPagination(index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsSearch(@RequestParam String field, @RequestParam String sign, @RequestParam String input, @RequestParam String index) {
        List<ListDrugDTO> drugs = (List<ListDrugDTO>) drugService.findAllDrugsSearch(field, sign, input, index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/search-like")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsLikePagination(@RequestParam String field, @RequestParam String input, @RequestParam String index) {
        List<ListDrugDTO> drugs = (List<ListDrugDTO>) drugService.findAllDrugsLikePagination(field, input, index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/search-not-pagination")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsSearchNotPagination(@RequestParam String field, @RequestParam String sign, @RequestParam String input) {
        List<ListDrugDTO> drugs = (List<ListDrugDTO>) drugService.findAllDrugsSearchNotPagination(field, sign, input);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/not-pagination")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsNotPagination() {
        List<ListDrugDTO> drugs = (List<ListDrugDTO>) drugService.findAllDrugsNotPagination();
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DrugDTO> deleteById(@PathVariable Long id) {
        DrugDTO drug = drugService.findDrugById(id);
        if (drug == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        drugService.deleteDrugById(id);
        return new ResponseEntity<DrugDTO>(drug, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DrugDTO> findById(@PathVariable Long id) {
        DrugDTO drugDTO = drugService.findDrugById(id);
        if (drugDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DrugDTO>(drugDTO, HttpStatus.OK);
    }
}
  