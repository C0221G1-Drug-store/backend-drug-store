package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImportBillRepository extends JpaRepository<ImportBill,Long> {

    @Query(value = "select * from import_bill where manufacture_id = ?1",nativeQuery = true)
    List<ImportBill> findByIdManufacturer(Long id);
}
