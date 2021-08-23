package com.backend.pharmacy_management.model.entity.import_bill_payment;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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
    Integer lotNumber ;
    String expiry ;
    Integer vat;
    private Boolean flag=true;

    @ManyToOne
    @JoinColumn(name = "import_bill_id")
    ImportBill importBill;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    Drug drug;

    @OneToOne(mappedBy = "importBillDrug")
    @JsonIgnore
    private ExportBillDetail exportBillDetail;
}
