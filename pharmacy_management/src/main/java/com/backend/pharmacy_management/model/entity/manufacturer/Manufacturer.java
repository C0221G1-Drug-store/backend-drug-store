package com.backend.pharmacy_management.model.entity.manufacturer;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manufacturerId;
    private String manufacturerCode;
    private String manufacturerName;
    private String manufacturerAddress;
    private String manufacturerEmail;
    private String manufacturerPhoneNumber;
    private Double manufacturerDebts;
    private String manufacturerNote ;
    @OneToMany(mappedBy = "manufacturer")
    @JsonManagedReference(value = "manufacturer-import_bill")
    @Fetch(value= FetchMode.SELECT)
    private List<ImportBill> importBills;
    @OneToMany(mappedBy = "manufacturer")
    @JsonManagedReference(value = "manufacturer-export_bill")
    private List<ExportBill> exportBills;
}
