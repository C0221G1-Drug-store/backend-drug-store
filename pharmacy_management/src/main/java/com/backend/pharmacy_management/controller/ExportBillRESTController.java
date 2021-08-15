package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExportBillRESTController {

    @Autowired
    IExportBillService iExportBillService;

    @CrossOrigin(origins = "http://localhost:4200/export-bill")
    @RequestMapping(value = "/export-bill",
    method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE,
    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Page<ExportBill> getExportBill(@PageableDefault(size = 10) Pageable pageable) {
        Page<ExportBill> exportBillPage = this.iExportBillService.findAll(pageable);
        return exportBillPage;
    }

}
