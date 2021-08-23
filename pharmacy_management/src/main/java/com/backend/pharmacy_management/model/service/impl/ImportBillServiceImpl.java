package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.dto.ImportBillDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.repository.IImportBillRepository;
import com.backend.pharmacy_management.model.service.IImportBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImportBillServiceImpl implements IImportBillService {
    @Autowired
    IImportBillRepository importBillRepository;

    @Override
    public Optional<ImportBill> findById(Long id) {
        return importBillRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        importBillRepository.deleteById(id);
    }

    @Override
    public List<ImportBillDto> getImportBillDto(int index) {
        return importBillRepository.getImportBillDto(index);
    }
    @Override
    public Page<ImportBill> getPageImportBillDto(Pageable pageable) {
        return importBillRepository.getPageImportBillDto(pageable);
    }

    @Override
    public Page<ImportBillDto> searchAndSortPaging(String billCode, String startDate, String endDate, String col, int pageable) {
        List<ImportBillDto>importBillDtoList = importBillRepository.searchAndSortPaging(billCode, startDate,endDate,col);
        Pageable pageable1 = PageRequest.of(pageable, 5);
        int start = (int) pageable1.getOffset();
        int end = Math.min((start + pageable1.getPageSize()), importBillDtoList.size());
        Page<ImportBillDto> pages = new PageImpl<ImportBillDto>(importBillDtoList.subList(start, end), pageable1, importBillDtoList.size());
        return pages;
    }

    @Override
    public Page<ImportBillDto> searchAndPaging(String billCode, String startDate, String endDate, String col,String sort, int pageable) {
        List<ImportBillDto>importBillDtoList = importBillRepository.searchAndPaging(billCode, startDate,endDate,col,sort);
        Pageable pageable1 = PageRequest.of(pageable, 5);
        int start = (int) pageable1.getOffset();
        int end = Math.min((start + pageable1.getPageSize()), importBillDtoList.size());
        Page<ImportBillDto> pages = new PageImpl<ImportBillDto>(importBillDtoList.subList(start, end), pageable1, importBillDtoList.size());
        return pages;
    }

    @Override
    public Page<ImportBillDto> getAllBill(int pageable) {
        List<ImportBillDto>importBillDtoList = importBillRepository.getAllBill();
        Pageable pageable1 = PageRequest.of(pageable, 5);
        int start = (int) pageable1.getOffset();
        int end = Math.min((start + pageable1.getPageSize()), importBillDtoList.size());
        Page<ImportBillDto> pages = new PageImpl<ImportBillDto>(importBillDtoList.subList(start, end), pageable1, importBillDtoList.size());
        return pages;
    }

    @Override
    public void deleteImportBill(Long id) {
        importBillRepository.deleteImportBill(id);
    }


}
