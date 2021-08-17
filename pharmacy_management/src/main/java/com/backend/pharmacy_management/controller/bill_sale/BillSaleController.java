package com.backend.pharmacy_management.controller.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.service.bill_sale.IDrugOfBillService;
import com.backend.pharmacy_management.model.service.bill_sale.IDrugService;
import com.backend.pharmacy_management.model.service.bill_sale.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BillSaleController {
    @Autowired
    IPrescriptionService iPrescriptionService;
    @Autowired
    IDrugOfBillService iDrugOfBillService;

    @Autowired
    IDrugService iDrugService;
    @GetMapping("/prescription")
    public ResponseEntity<List<Prescription>> showPrescriptionList(){
        List<Prescription> list = iPrescriptionService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/drug")
    public ResponseEntity<List<Drug>> showDrugList() {
        List<Drug> list = iDrugService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/drug-of-bill/{id}")
    public ResponseEntity<List<DrugOfBill>> showDrugOfBillList(@PathVariable("id") int id){
        List<DrugOfBill> list = iDrugOfBillService.findAllDrugOfBill(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
    @GetMapping("/prescription/{id}")
    public ResponseEntity<Prescription> showPres(@PathVariable("id") int id){
        Prescription prescription = iPrescriptionService.findById(id);
        if (prescription == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }
}
