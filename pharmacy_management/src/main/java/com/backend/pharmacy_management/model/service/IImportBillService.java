package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IImportBillService extends IGeneralService<ImportBill> {
    List<ImportBill>getAllImportBill(int index);
    List<ImportBill>getAllImportBillNotPagination();
    List<ImportBill>search(String importCode);
    List<ImportBill>searchBill(String importCode,String startDate,String endDate,String sort);
    List<ImportBill>selName(String billCode,String startDate,String endDate,String col);
    Page<ImportBill>getAllBill(Pageable pageable);
}
