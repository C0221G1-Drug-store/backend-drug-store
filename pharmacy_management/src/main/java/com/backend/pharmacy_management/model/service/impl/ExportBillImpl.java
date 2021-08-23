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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ExportBillImpl implements ExportBillService {
    @Autowired
    private ExportBillRepository exportBillRepository;
    @Autowired
    private ExportBillDetailRepository exportBillDetailRepository;

    private final Random rand = SecureRandom.getInstanceStrong();

    public ExportBillImpl() throws NoSuchAlgorithmException {
        // Do nothing
    }

    @Override
    public List<String> getAllExportBillCode() {
        return this.exportBillRepository.getAllExportBillCode();
    }

    @Override
    public void createExportBill(ExportBill exportBill) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        exportBill.setExportBillDate(dateFormat.format(new Date()));
        this.exportBillRepository.save(exportBill);
    }

    @Override
    public void createExportBillDetail(ExportBillDetail exportBillDetail) {
        this.exportBillDetailRepository.save(exportBillDetail);
    }

    @Override
    public String createExportBillRefundCode() {
        List<String> listCode = getAllExportBillCode();
        StringBuilder stringCode;
        do {
            stringCode = new StringBuilder("HDXT");
            for(int i = 0; i < 5; i++) {
                stringCode.append(rand.nextInt(9));
            }
        }while (listCode.contains(stringCode.toString()));
        return stringCode.toString();
    }

    @Override
    public String createExportBillDestroyCode() {
        List<String> listCode = getAllExportBillCode();
        StringBuilder result ;
        do {
            result = new StringBuilder("HDXH");
            for (int i = 0; i < 5; i++) {
                result.append(rand.nextInt(9));
            }
        } while (!listCode.isEmpty() && listCode.contains(result.toString()));
        return result.toString();
    }
}
