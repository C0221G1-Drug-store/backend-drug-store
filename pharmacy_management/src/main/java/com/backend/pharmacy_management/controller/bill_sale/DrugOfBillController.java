package com.backend.pharmacy_management.controller.bill_sale;

import com.backend.pharmacy_management.model.service.bill_sale.IDrugOfBillService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class DrugOfBillController {
    @Autowired
    IDrugOfBillService iDrugOfBillService;

}
