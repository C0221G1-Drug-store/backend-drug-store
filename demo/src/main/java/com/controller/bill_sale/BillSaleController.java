package com.controller.bill_sale;
import com.backend.pharmacy_management.model.dto.bill_sale.BillSaleDto;
import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.service.bill_sale.IBillSaleService;
import com.backend.pharmacy_management.model.service.bill_sale.IDrugOfBillService;
import com.backend.pharmacy_management.model.service.bill_sale.IDrugService;
import com.backend.pharmacy_management.model.service.bill_sale.IPrescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BillSaleController {
    @Autowired
    IPrescriptionService iPrescriptionService;
    @Autowired
    IDrugOfBillService iDrugOfBillService;
    @Autowired
    IBillSaleService iBillSaleService;
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
    @PostMapping("prescription/bill")
    public void save(@RequestBody BillSaleDto billSaleDto) {
        BillSale billSale =new BillSale();
        if (billSaleDto != null){
            BeanUtils.copyProperties(billSaleDto,billSale);
        }
        iBillSaleService.saveBill(billSale);
    }

    @GetMapping("prescription/search")
    public ResponseEntity<List<Prescription>> searchPrescription(@RequestParam String fieldSearch, @RequestParam String valueSearch){


        List<Prescription> list = iPrescriptionService.search(fieldSearch, valueSearch);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping("prescription/save")
    public void  saveDrugOfBIll(@RequestBody DrugOfBill drugOfBill) {
        iDrugOfBillService.save(drugOfBill);
    }
    @GetMapping("/prescription/find-bill")
    public ResponseEntity<BillSale> findNewBill(){
        BillSale bill = iBillSaleService.findBIll();
        return new  ResponseEntity<>(bill, HttpStatus.OK);
    }

}
