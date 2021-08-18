package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.repository.ExportBillDetailRepository;
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
    @Autowired
    private ExportBillDetailRepository exportBillDetailRepository;


    @Override
    public List<String> getAllExportBillCode() {
        return this.exportBillRepository.getAllExportBillCode();
    }

    @Override
    public void createExportBill(ExportBill exportBill) {
        this.exportBillRepository.save(exportBill);
    }

    @Override
    public void createExportBillDetail(ExportBillDetail exportBillDetail) {
        this.exportBillDetailRepository.save(exportBillDetail);
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

    @Override
    public String createExportBillDestroyCode() {
        List<String> listCode = getAllExportBillCode();
        StringBuilder result ;
        Random ran = new Random();
        do {
            result = new StringBuilder("HDXH");
            for (int i = 0; i < 5; i++) {
                result.append(ran.nextInt(9));
            }
        } while (!listCode.isEmpty() && listCode.contains(result.toString()));
        return result.toString();
    }
}
