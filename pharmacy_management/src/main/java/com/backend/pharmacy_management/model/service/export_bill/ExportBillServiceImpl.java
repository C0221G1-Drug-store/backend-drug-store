package com.backend.pharmacy_management.model.service.export_bill;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.repository.export_bill.IExportBillDetailRepository;
import com.backend.pharmacy_management.model.repository.export_bill.IExportBillRepository;
import com.backend.pharmacy_management.model.repository.export_bill.IExportBillTypeRepository;
import com.backend.pharmacy_management.model.service.IExportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ExportBillServiceImpl implements IExportBillService {
    @Autowired
    private IExportBillRepository exportBillRepository;

    @Autowired
    private IExportBillTypeRepository exportBillTypeRepository;

    @Autowired
    private IExportBillDetailRepository iExportBillDetailRepository;

    @Override
    public void createExportBill(ExportBill exportBill) {
        this.exportBillRepository.save(exportBill);
    }

    @Override
    public void createExportBillDetail(ExportBillDetail exportBillDetail) {
        this.iExportBillDetailRepository.save(exportBillDetail);
    }

    @Override
    public List<ExportBillType> getListExportBillTye() {
        return this.exportBillTypeRepository.findAll();
    }

    @Override
    public String createCodeExportBill() {
        List<String> listCode = this.exportBillRepository.getListCode();
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

    @Override
    public List<ExportBill> getAll() {
        return this.exportBillRepository.findAll();
    }


}
