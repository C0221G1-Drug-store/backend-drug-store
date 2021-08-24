package com.backend.pharmacy_management.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDrugOfBillRepository extends JpaRepository<DrugOfBill, Long> {
    @Query(value = "select * from  drug_of_bill   where prescription_id = ? ;", nativeQuery = true)
    List<DrugOfBill> findAllDrugOfBill(int id);
}
