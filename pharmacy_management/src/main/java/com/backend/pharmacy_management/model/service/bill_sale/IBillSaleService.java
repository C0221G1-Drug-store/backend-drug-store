package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.IGeneralService;

public interface IBillSaleService extends IGeneralService<BillSale> {
    BillSale saveB(BillSale billSale);
}
