package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.repository.ExportBillRepository;
import com.backend.pharmacy_management.model.service.ExportBillService;
import com.backend.pharmacy_management.model.service.ExportBillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ExportBillImpl implements ExportBillService {
    @Autowired
    private ExportBillRepository exportBillRepository;



    @Override
    public List<String> getAllExportBillCode() {
        return this.exportBillRepository.getAllExportBillCode();
    }
    @Override
    public String createExportBillRefundCode() {
        List<String> listCode = getAllExportBillCode();
        StringBuffer stringCode;
        Random random = new Random();
        do {
            stringCode = new StringBuffer("HDXT");
            for(int i = 0; i < 5; i++) {
                stringCode.append(random.nextInt(9));
            }
        }while (listCode.contains(stringCode.toString()));
        return stringCode.toString();
    }
}
