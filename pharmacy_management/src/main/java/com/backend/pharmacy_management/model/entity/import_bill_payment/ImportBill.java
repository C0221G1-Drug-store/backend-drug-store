package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill")
public class ImportBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long importBillId;
    private String importSystemCode;
    private String accountingVoucher;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime invoiceDate;
    private Boolean flag ;
    @OneToOne
    @JoinColumn(name = "payment_id")
    @JsonManagedReference(value = "payment-import_bill")
    private  Payment payment;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonBackReference(value = "manufacturer-import_bill")
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "employee-import_bill")
    private Employee employee;
    @OneToMany(mappedBy = "importBill")
    @JsonManagedReference(value = "import_bill_drug-import_bill")
    private List<ImportBillDrug> importBillDrugs;

}
