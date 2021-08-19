package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.repository.ExportBillDetailRepository;
import com.backend.pharmacy_management.model.repository.ExportBillRepository;
import com.backend.pharmacy_management.model.service.ExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
public class ExportBillImpl implements ExportBillService {
    private Random rand = SecureRandom.getInstanceStrong();


    @Autowired
    private ExportBillRepository exportBillRepository;
    @Autowired
    private ExportBillDetailRepository exportBillDetailRepository;

    public ExportBillImpl() throws NoSuchAlgorithmException {

        // chú thích
    }


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
        StringBuilder stringCode =new StringBuilder("HDXT");
        do {
            for(int i = 0; i < 5; i++) {
                stringCode.append(rand.nextInt(9));
            }
        }while (listCode.contains(stringCode.toString()));
        return stringCode.toString();
    }
}
