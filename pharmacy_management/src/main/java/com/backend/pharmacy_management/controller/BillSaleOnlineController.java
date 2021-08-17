package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.service.bill_sale.IBillSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class BillSaleOnlineController {
    @Autowired
    IBillSaleService iBillSaleService;
    @PostMapping("/bill_sale/save")
    public ResponseEntity<BillSale> save(@RequestBody BillSale billSale) {
        return new ResponseEntity<>(iBillSaleService.saveB(billSale), HttpStatus.CREATED);
    }

}
