package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill_drug")
public class ImportBillDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long importBillDrugId;
    Integer importAmount;
    Double importPrice;
    Integer discountRate;
    Integer lotNumber;
    Date expiry;
    Integer vat;
    Boolean flag;
    @ManyToOne
    @JoinColumn(name = "import_bill_id")
    @JsonBackReference(value = "import_bill_drug-import_bill")
    ImportBill importBill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonBackReference(value = "import_bill_drug-drug")
    Drug drug;
}
