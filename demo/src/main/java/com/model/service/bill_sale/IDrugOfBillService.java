package com.model.service.bill_sale;



import com.model.entity.bill_sale.DrugOfBill;

import java.util.List;

public interface IDrugOfBillService {
    List<DrugOfBill> findAllDrugOfBill(int id);
}
