package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.repository.bill_sale.IBillSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillSaleService implements IBillSaleService {
    @Autowired
    IBillSaleRepository iBillSaleRepository;
    @Override
    public Optional<BillSale> findBillSaleById(Long id) {
        return iBillSaleRepository.findById(id);
    }

    @Override
    public void save(BillSale billSale) {
        iBillSaleRepository.save(billSale);
    }

    @Override
    public void remove(Long id) {
        iBillSaleRepository.deleteById(id);
    }
}
