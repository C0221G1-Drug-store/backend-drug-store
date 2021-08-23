package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.dto.ListImportDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.repository.import_bill.IListImportDtoRepository;
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
    IListImportDtoRepository importBillRepository;

    @Override
    public Page<ImportBill> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<ImportBill> findById(Long id) {
        return importBillRepository.findById(id);
    }

    @Override
    public List<ImportBill> findAllNormal() {
        return null;
    }

    @Override
    public void save(ImportBill importBill) {

    }

    @Override
    public void remove(Long id) {
        importBillRepository.deleteById(id);
    }

    @Override
    public List<ListImportDto> getListImportDto(int index) {
        return importBillRepository.getListImportDto(index);
    }
    @Override
    public Page<ImportBill> getPageListImportDto(Pageable pageable) {
        return importBillRepository.getPageListImportDto(pageable);
    }

    @Override
    public Page<ListImportDto> searchAndSortPaging(String billCode, String startDate, String endDate, String col, int pageable) {
        List<ListImportDto>importBillDtoList = importBillRepository.searchAndSortPaging(billCode, startDate,endDate,col);
        Pageable pageable1 = PageRequest.of(pageable, 5);
        int start = (int) pageable1.getOffset();
        int end = Math.min((start + pageable1.getPageSize()), importBillDtoList.size());
        Page<ListImportDto> pages = new PageImpl<ListImportDto>(importBillDtoList.subList(start, end), pageable1, importBillDtoList.size());
        return pages;
    }

    @Override
    public Page<ListImportDto> searchAndPaging(String billCode, String startDate, String endDate, String col,String sort, int pageable) {
        List<ListImportDto>importBillDtoList = importBillRepository.searchAndPaging(billCode, startDate,endDate,col,sort);
        Pageable pageable1 = PageRequest.of(pageable, 5);
        int start = (int) pageable1.getOffset();
        int end = Math.min((start + pageable1.getPageSize()), importBillDtoList.size());
        Page<ListImportDto> pages = new PageImpl<ListImportDto>(importBillDtoList.subList(start, end), pageable1, importBillDtoList.size());
        return pages;
    }

    @Override
    public Page<ListImportDto> getAllBill(int pageable) {
        List<ListImportDto>importBillDtoList = importBillRepository.getAllBill();
        Pageable pageable1 = PageRequest.of(pageable, 5);
        int start = (int) pageable1.getOffset();
        int end = Math.min((start + pageable1.getPageSize()), importBillDtoList.size());
        Page<ListImportDto> pages = new PageImpl<ListImportDto>(importBillDtoList.subList(start, end), pageable1, importBillDtoList.size());
        return pages;
    }

    @Override
    public void deleteImportBill(Long id) {
        importBillRepository.deleteImportBill(id);
    }


}
