package com.backend.pharmacy_management.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBillSaleRepository extends JpaRepository<BillSale,Long> {
//    @Query(value = "select * from  bill_sale where bill_sale_id = ? ;", nativeQuery = true)
//    BillSale findBillSaleById(Long id);
}
