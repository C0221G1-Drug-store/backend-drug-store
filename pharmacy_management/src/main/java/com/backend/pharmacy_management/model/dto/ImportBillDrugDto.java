package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportBillDrugDto {
    Long importBillDrugId;
    @NotNull
    @Min(0)
    Integer importAmount;
    @NotNull
    @Min(0)
    Double importPrice;
    @NotNull
    @Min(0)
    Integer discountRate;
    @NotNull
    Integer lotNumber;
    @NotNull
    Date expiry;
    @NotNull
    Integer vat;
    Boolean flag;
    ImportBill importBill;
    Drug drug;
}
