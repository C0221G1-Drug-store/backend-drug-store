package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.dto.ImportBillDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IImportBillService extends IGeneralService<ImportBill> {
    List<ImportBillDto> getImportBillDto(int index);

    Page<ImportBill> getPageImportBillDto(Pageable pageable);

    Page<ImportBillDto> searchAndSortPaging(String billCode, String startDate, String endDate, String col, int pageable);
    Page<ImportBillDto> searchAndPaging(String billCode, String startDate, String endDate, String col,String sort, int pageable);

    Page<ImportBillDto> getAllBill(int pageable);
    void deleteImportBill(Long id);
}
