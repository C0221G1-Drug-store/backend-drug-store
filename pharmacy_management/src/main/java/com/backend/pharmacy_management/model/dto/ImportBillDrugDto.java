package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportBillDrugDto {
    Long importBillDrugId;
    Integer importAmount;
    Double importPrice;
    Integer discountRate;
    Integer lotNumber;
    Date expiry;
    Integer vat;
    Boolean flag;
    ImportBill importBill;
    Drug drug;
}
