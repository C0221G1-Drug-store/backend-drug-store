package com.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime invoiceDate;
    private Boolean flag = true;
    @OneToOne
    @JoinColumn(name = "payment_id")
    @JsonManagedReference
    private  Payment payment;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonManagedReference
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private Employee employee;
    @OneToMany(mappedBy = "importBill",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ImportBillDrug> importBillDrugs;
}
