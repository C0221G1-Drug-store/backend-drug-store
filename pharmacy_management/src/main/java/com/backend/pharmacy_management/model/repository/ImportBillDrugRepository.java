package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImportBillDrugRepository extends JpaRepository<ImportBillDrug,Long> {
//    @Query(value = "SELECT im.discount_rate, im.expiry, im.import_amount, im.import_price, mn.manufacturer_name, mn.manufacturer_address,drug.drug_name,drug.unit \n" +
//            "FROM manufacturer  as mn  join import_bill as imb \n" +
//            "on mn.manufacturer_id = imb.manufacturer_id join import_bill_drug as im\n" +
//            "on imb.import_bill_id =  im.import_bill_id  join drug \n" +
//            "on drug.drug_id = im.drug_id\n" +
//            "where mn.manufacturer_id = ?1" ,nativeQuery = true)
        @Query(value = "SELECT im.* \n" +
                "FROM manufacturer  as mn  join import_bill as imb \n" +
                "on mn.manufacturer_id = imb.manufacturer_id join import_bill_drug as im\n" +
                "on imb.import_bill_id =  im.import_bill_id  join drug \n" +
                "on drug.drug_id = im.drug_id\n" +
                "where mn.manufacturer_id = ?", nativeQuery = true)
        List<ImportBillDrug> getAllImportBillDrugByManufacuterId(Long id);

        @Query(value = "select * from import_bill_drug d where d.import_amount > 0 && d.flag=1", nativeQuery = true)
        List<ImportBillDrug> getAll();

}
