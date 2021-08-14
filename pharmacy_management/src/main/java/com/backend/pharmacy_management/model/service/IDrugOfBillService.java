package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.repository.IDrugOfBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDrugOfBillService {
    List<DrugOfBill> findAllDrugOfBill(int id);
}
