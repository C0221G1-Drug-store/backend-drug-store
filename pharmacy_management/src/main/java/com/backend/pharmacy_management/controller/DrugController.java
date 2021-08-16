package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/not-pagination")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsNotPagination() {
        List<ListDrugDTO> drugs = (List<ListDrugDTO>) drugService.findAllDrugsNotPagination();
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
}
  