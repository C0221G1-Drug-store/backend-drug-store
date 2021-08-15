package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportBillRepository extends PagingAndSortingRepository<ExportBill, Long> {
}
