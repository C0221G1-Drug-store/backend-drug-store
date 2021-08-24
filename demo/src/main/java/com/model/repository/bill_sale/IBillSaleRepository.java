package com.model.repository.bill_sale;


import com.model.entity.bill_sale.BillSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBillSaleRepository extends JpaRepository<BillSale,Long> {

    @Query(value = "select * from bill_sale \n" +
            "where bill_sale_id =  (select max(bill_sale_id) as maxId \n" +
            "from bill_sale)", nativeQuery = true)
    BillSale findBIllNew();
}
