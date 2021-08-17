package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.repository.bill_sale.IBillSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillSaleService implements IBillSaleService {
    @Autowired
    IBillSaleRepository iBillSaleRepository;

    @Override
    public Page<BillSale> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<BillSale> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<BillSale> findAllNormal() {
        return null;
    }

    @Override
    public void save(BillSale billSale) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public BillSale saveB(BillSale billSale) {
        return iBillSaleRepository.save(billSale) ;
    }
}
