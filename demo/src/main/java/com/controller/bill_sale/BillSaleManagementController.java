package com.controller.bill_sale;


import com.model.entity.bill_sale.BillSale;
import com.model.service.bill_sale.IBillSaleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bill")
public class BillSaleManagementController {
    @Autowired
    private IBillSaleManagementService billSaleManagementService;

    @GetMapping()
    public ResponseEntity<Page<BillSale>> findAllBillPage(@RequestParam Integer page) {
        Page<BillSale> billList = billSaleManagementService.findAllBillPage(PageRequest.of(page, 5));
        if (billList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<BillSale>> findBillBySearch(@RequestParam("search1") String search1, @RequestParam("search2") String search2,
                                                           @RequestParam("search3") String search3, @RequestParam("search4") String search4,
                                                           @RequestParam("search5") String search5,
                                                           @RequestParam("search6") String search6,
                                                           @RequestParam Integer page

    ) {

        Page<BillSale> billList;

            switch (search6) {
                case "":
                    billList = billSaleManagementService.findBillBySearchPage(search1, search2, search3, search4, search5,PageRequest.of(page,5));
                    break;
                case "1":
                    billList = billSaleManagementService.findBillBySearchPage1(search1, search2, search3, search4, search5,PageRequest.of(page,5));
                    break;
                case "2":
                    billList = billSaleManagementService.findBillBySearchPage2(search1, search2, search3, search4, search5,PageRequest.of(page,5));
                    break;
                case "3":
                    billList = billSaleManagementService.findBillBySearchPage3(search1, search2, search3, search4, search5,PageRequest.of(page,5));
                    break;
                case "4":
                    billList = billSaleManagementService.findBillBySearchPage4(search1, search2, search3, search4, search5,PageRequest.of(page,5));
                    break;
                case "5":
                    billList = billSaleManagementService.findBillBySearchPage5(search1, search2, search3, search4, search5,PageRequest.of(page,5));
                    break;

                default:
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BillSale> findBillById(@PathVariable Long id) {
        Optional<BillSale> billOptional = billSaleManagementService.findBillSaleById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billOptional.get(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deleteBillById(@PathVariable Long id) {
        billSaleManagementService.deleteBillById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
