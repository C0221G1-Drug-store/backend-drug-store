package com.backend.pharmacy_management.controller.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;

import com.backend.pharmacy_management.model.service.bill_sale.IDrugOfBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrugOfBillController {
    @Autowired
    IDrugOfBillService iDrugOfBillService;
    @GetMapping("/drug-of-bill/{id}")
    public ResponseEntity<List<DrugOfBill>> showDrugOfBillList(@PathVariable("id") Long id){
        List<DrugOfBill> list = iDrugOfBillService.findAllDrugOfBill(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

}
