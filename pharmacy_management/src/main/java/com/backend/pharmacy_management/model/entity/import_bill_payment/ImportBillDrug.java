package com.backend.pharmacy_management.model.entity.import_bill_payment;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill_drug")
public class ImportBillDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ImportBillDrugId;
    Integer importAmount;
    Double importPrice;
    Integer discountRate;
    Integer lotNumber ;
    Date expiry ;
    Integer vat;
    Boolean flag;
    @ManyToOne
    @JoinColumn(name = "import_bill_id")
    @JsonManagedReference
    ImportBill importBill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonManagedReference
    Drug drug;
}
