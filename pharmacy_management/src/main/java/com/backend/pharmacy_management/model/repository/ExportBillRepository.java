package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportBillRepository extends JpaRepository<ExportBill, Long> {
    @Query(value = "select * from export_bill where cast(export_bill.date_create as time) > cast(?1 as time) and cast(export_bill.date_create as time) < cast(?2 as time) in (select * from export_bill where export_bill.type_export_bill_id = ?3);", nativeQuery = true)
    Page<ExportBill> findByTimeFields(String timeCreate, String toTime, long typeId, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.date_create as time) > cast(?1 as time) and cast(export_bill.date_create as time) < cast(?2 as time) in (select * from export_bill where export_bill.type_export_bill_id = ?3 and export_bill.);", nativeQuery = true)

    @Query(value = "select * from export_bill where cast(export_bill.date_create as date) > cast(?1 as date) and cast(export_bill.date_create as date) < cast(?2 as date) in (select * from export_bill where export_bill.type_export_bill_id = ?3);", nativeQuery = true)
    Page<ExportBill> findByDateFields(String dateCreate, String toDate, long typeId, Pageable pageable);

    @Query(value = "select * from export_bill where cast(export_bill.date_create as time) > cast(?3 as time) and cast(export_bill.date_create as time) < cast(?4 as time) and cast(export_bill.date_create as date) > cast(?1 as date) and cast(export_bill.date_create as date) < cast(?2 as date) in (select * from export_bill where export_bill.type_export_bill_id = ?5);", nativeQuery = true)
    Page<ExportBill> findBy4Fields(String dateCreate, String toDate, String timeCreate, String toTime, long typeId, Pageable pageable);
}
