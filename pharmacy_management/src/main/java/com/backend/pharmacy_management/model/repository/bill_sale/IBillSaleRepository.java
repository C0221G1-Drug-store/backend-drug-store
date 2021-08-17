package com.backend.pharmacy_management.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillSaleRepository extends JpaRepository<BillSale,Long> {

}
