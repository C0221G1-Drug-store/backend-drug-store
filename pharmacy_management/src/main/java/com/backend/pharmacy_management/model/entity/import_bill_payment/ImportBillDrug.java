package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
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

    @OneToOne(mappedBy = "importBillDrug", cascade = CascadeType.ALL)
    @JsonIgnore
    ExportBillDetail exportBillDetail;

    public ImportBillDrug() {
    }

}
