package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill_drug")
public class ImportBillDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ImportBillDrugId;
    private Integer importAmount;
    private Double importPrice;
    private Integer discountRate;
    private Integer lotNumber;
    private Date expiry;
    private Integer vat;
    private Boolean flag = true;

    @ManyToOne
    @JoinColumn(name = "import_bill_id")
    @JsonManagedReference(value = "import-detail")
    private ImportBill importBill;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonManagedReference(value = "drug-detail")
    private Drug drug;

    @OneToOne(mappedBy = "importBillDrug")
    private ExportBillDetail exportBillDetail;
}
