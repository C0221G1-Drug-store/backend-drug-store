package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.dto.ListImportDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IImportBillService extends IGeneralService<ImportBill> {
    List<ListImportDto> getListImportDto(int index);

    Page<ImportBill> getPageListImportDto(Pageable pageable);

    Page<ListImportDto> searchAndSortPaging(String billCode, String startDate, String endDate, String col, int pageable);
    Page<ListImportDto> searchAndPaging(String billCode, String startDate, String endDate, String col,String sort, int pageable);

    Page<ListImportDto> getAllBill(int pageable);
    void deleteImportBill(Long id);
}
