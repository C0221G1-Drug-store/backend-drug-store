package com.backend.pharmacy_management.model.repository.manufacturer;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportBillRepository extends JpaRepository<ImportBill, Integer> {
    @Query(value="select * from import_bill join manufacturer on manufacturer.manufacturer_id=import_bill.manufacturer_id where manufacturer.manufacturer_id = ?1", nativeQuery = true)
    Page<ImportBill> findAllByImportBill(Integer id, Pageable pageable);
}
