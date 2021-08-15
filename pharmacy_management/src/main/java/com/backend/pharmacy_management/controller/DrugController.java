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

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private IDrugService drugService;
    @GetMapping
    public ResponseEntity<List<DrugDTO>> finAllDrugs(@RequestParam int index) {
        List<DrugDTO> drugs = (List<DrugDTO>) drugService.findAllDrugs(index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
}
  