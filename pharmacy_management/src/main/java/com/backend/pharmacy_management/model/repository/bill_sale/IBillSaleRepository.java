package com.backend.pharmacy_management.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillSaleRepository extends JpaRepository<BillSale,Long> {
    @Query(value = "select * from bill_sale where concat(bill_sale_code, bill_sale_id) = ?", nativeQuery = true)
    BillSale findBillSaleByIdCode(String id);

}
