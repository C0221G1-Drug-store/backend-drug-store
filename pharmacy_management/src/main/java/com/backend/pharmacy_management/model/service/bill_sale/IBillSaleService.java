package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;

public interface IBillSaleService {
    void saveBill(BillSale bill);
    BillSale findBIll();
}
