package com.backend.pharmacy_management.controller.bill_sale;

import com.backend.pharmacy_management.model.dto.BillSaleDto;
import com.backend.pharmacy_management.model.dto.DrugOfBillDto;
import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.bill_sale.IBillSaleService;
import com.backend.pharmacy_management.model.service.bill_sale.IDrugOfBillService;
import com.backend.pharmacy_management.model.service.customer.ICustomerService;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200/")
@RequestMapping(value = "bill-sale")
public class BillSaleController {
    @Autowired
    IDrugService iDrugService;
    @Autowired
    IBillSaleService iBillSaleService;
    @Autowired
    IDrugOfBillService iDrugOfBillService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping(value = "/get-list-drug")
    public ResponseEntity<List<Drug>> getListDrug() {
        List<Drug> drugList = iDrugService.findAllNormal();
        if (drugList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(drugList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get-list-employee")
    public ResponseEntity<List<Employee>> getListEmployee() {
        List<Employee> employeeList = iEmployeeService.findAllNormal();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get-list-customer")
    public ResponseEntity<List<Customer>> getListCustomer() {
        List<Customer> customerList = iCustomerService.findAllNormal();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get-list-drug-of-bill")
    public ResponseEntity<List<DrugOfBill>> getListDrugOfBillByBillSaleId(@RequestParam String id) {
        List<DrugOfBill> drugOfBillList = iDrugOfBillService.findAllDrugOfBillByBillSaleId(id);
        if (drugOfBillList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(drugOfBillList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/find-drug-by-id")
    public ResponseEntity<Optional<Drug>> findDrugById(@RequestParam Long id) {
        Optional<Drug> drug = iDrugService.findById(id);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }

    @GetMapping(value = "get-bill-sale")
    public ResponseEntity<Optional<BillSale>> getBillSale(@RequestParam String id ){
        Optional<BillSale> billSale = Optional.ofNullable(iBillSaleService.findBillSaleByIdCode(id));
        return new ResponseEntity<>(billSale, HttpStatus.OK);
    }

    @PostMapping(value = "/create-bill-sale")
    public ResponseEntity<BillSale> createBillSale(@Valid @RequestBody BillSaleDto billSaleDto) {
        BillSale billSale = new BillSale();
        BeanUtils.copyProperties(billSaleDto, billSale);
        this.iBillSaleService.save(billSale);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/create-drug-of-bill")
    public ResponseEntity<DrugOfBill> createDrugOfBill(@RequestBody DrugOfBillDto drugOfBillDto) {
        DrugOfBill drugOfBill = new DrugOfBill();
        BeanUtils.copyProperties(drugOfBillDto, drugOfBill);
        this.iDrugOfBillService.save(drugOfBill);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update-drug")
    public ResponseEntity<Drug> updateDrug(@RequestBody Drug drug) {
        this.iDrugService.save(drug);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
