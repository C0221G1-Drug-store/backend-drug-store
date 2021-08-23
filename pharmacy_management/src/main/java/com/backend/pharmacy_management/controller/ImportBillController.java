package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.ImportBillDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.service.IImportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/import-bills")
public class ImportBillController {
    @Autowired
    private IImportBillService importBillService;

    @DeleteMapping("/{id}")
    public ResponseEntity<ImportBill> deleteBill(@PathVariable Long id) {
        Optional<ImportBill> importBillOptional = importBillService.findById(id);
        if (!importBillOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        importBillService.deleteImportBill(id);
        return new ResponseEntity<>(importBillOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list-bills")
    public ResponseEntity<List<ImportBillDto>> getImportBillDto(@RequestParam int index) {
        List<ImportBillDto> importBills = importBillService.getImportBillDto(index);
        if (importBills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ImportBill>> getListBill(@RequestParam Integer page) {
        Page<ImportBill> listPatient = importBillService.getPageImportBillDto(PageRequest.of(page, 5));
        return new ResponseEntity<>(listPatient, HttpStatus.OK);
    }

    @GetMapping("/search-sort-page")
    public ResponseEntity<Page<ImportBillDto>> searchAndSortBill(@RequestParam(defaultValue = "") String codeBill,
                                                                     @RequestParam(defaultValue = "") String startDate,
                                                                     @RequestParam(defaultValue = "") String endDate,
                                                                     @RequestParam(defaultValue = "") String col,
                                                                     @RequestParam int page) {
        Page<ImportBillDto> importBillDtoPage = importBillService.searchAndSortPaging(codeBill, startDate, endDate, col, page);
        if (importBillDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDtoPage, HttpStatus.OK);
    }

    @GetMapping("/list-bill-page")
    public ResponseEntity<Page<ImportBillDto>> searchListPage(@RequestParam int page) {
        Page<ImportBillDto> importBillDtoPage = importBillService.getAllBill(page);
        if (importBillDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDtoPage, HttpStatus.OK);
    }

    @GetMapping("/search-sort-page-bill")
    public ResponseEntity<Page<ImportBillDto>> searchAndSortPagingBill(@RequestParam(defaultValue = "") String codeBill,
                                                                 @RequestParam(defaultValue = "") String startDate,
                                                                 @RequestParam(defaultValue = "") String endDate,
                                                                 @RequestParam(defaultValue = "") String col,
                                                                 @RequestParam(defaultValue = "") String sort,
                                                                 @RequestParam int page) {
        Page<ImportBillDto> importBillDtoPage = importBillService.searchAndPaging(codeBill, startDate, endDate, col,sort, page);
        if (importBillDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDtoPage, HttpStatus.OK);
    }
}

