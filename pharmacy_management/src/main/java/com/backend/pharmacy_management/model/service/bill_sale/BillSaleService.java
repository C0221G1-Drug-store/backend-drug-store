package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.repository.bill_sale.IBillSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillSaleService implements IBillSaleService {

    @Autowired
    IBillSaleRepository iBillSaleRepository;
    @Override
    public void saveBill(BillSale bill) {
        iBillSaleRepository.save(bill);
    }
}
