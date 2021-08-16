package com.backend.pharmacy_management.model.service.bill_sale;



import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;

import java.util.Optional;

public interface IBillSaleService {
    Optional<BillSale> findBillSaleById(Long id);
    void save(BillSale billSale);
    void remove(Long id);
}
