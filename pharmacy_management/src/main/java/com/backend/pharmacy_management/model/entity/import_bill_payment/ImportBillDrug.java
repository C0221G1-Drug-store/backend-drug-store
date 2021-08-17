package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
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
    ImportBill importBill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    Drug drug;
}
