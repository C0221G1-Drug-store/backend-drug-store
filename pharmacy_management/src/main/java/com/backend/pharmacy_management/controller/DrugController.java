package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.dto.DrugDtoTuan;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;

import com.backend.pharmacy_management.model.service.drug.IDrugService;



import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;

import com.backend.pharmacy_management.model.service.drug_group.IDrugGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private IDrugService drugService;
    @Autowired
    private IDrugGroupService drugGroupService;
    @GetMapping
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsPagination(@RequestParam int index) {
        List<ListDrugDTO> drugs = drugService.findAllDrugsPagination(index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsSearch(@RequestParam String field, @RequestParam String sign, @RequestParam String input, @RequestParam String index) {
        if (!field.equals("") && sign.equals("like") && !input.equals("")) {
            input = '%' + input + '%';
        }
        List<ListDrugDTO> drugs = drugService.findAllDrugsSearch(field, sign, input, index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping("/search-not-pagination")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsSearchNotPagination(@RequestParam String field, @RequestParam String sign, @RequestParam String input) {
        if (!field.equals("") && sign.equals("like") && !input.equals("")) {
            input = '%' + input + '%';
        }
        List<ListDrugDTO> drugs = drugService.findAllDrugsSearchNotPagination(field, sign, input);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/not-pagination")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsNotPagination() {
        List<ListDrugDTO> drugs = drugService.findAllDrugsNotPagination();
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping(value = "/drugGroup")
    public ResponseEntity<List<DrugGroup>> getListDrugGroup(){
        List<DrugGroup> listDrugGroup = drugGroupService.findAllDrugGroup();
        if (listDrugGroup.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listDrugGroup,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Drug> saveDrug(@Valid @RequestBody DrugDtoTuan drugDtoTuan) {
        Drug drug = new Drug();
        BeanUtils.copyProperties(drugDtoTuan,drug);
        drug.setDrugCode ((long) Math.floor(Math.random()*1000000));
        return new ResponseEntity<>(drugService.saveDrug(drug), HttpStatus.CREATED);
    }
    @PostMapping(value = "/image")
    public ResponseEntity<DrugImageDetail> saveDrugImage(@Valid @RequestBody DrugImageDetail drugImageDetail) {

        return new ResponseEntity<>(drugService.saveDrugImage(drugImageDetail), HttpStatus.CREATED);
    }
    @PutMapping("/{id}&{code}")
    public ResponseEntity<Drug> updateBenhAn(@PathVariable Long id,@PathVariable Long code,@Valid @RequestBody Drug drug) {
        Drug drug1 = drugService.findById(id);
        BeanUtils.copyProperties(drug,drug);
        if (drug1==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        drug.setDrugId(drug1.getDrugId());
        drug.setDrugCode(code);
        return new ResponseEntity<>(drugService.saveDrug(drug), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DrugDTO> deleteById(@PathVariable Long id) {
        DrugDTO drug = drugService.findDrugById(id);
        if (drug == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        drugService.deleteDrugById(id);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DrugDTO> findById(@PathVariable Long id) {
        DrugDTO drugDTO = drugService.findDrugById(id);
        if (drugDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drugDTO, HttpStatus.OK);
    }
}
  