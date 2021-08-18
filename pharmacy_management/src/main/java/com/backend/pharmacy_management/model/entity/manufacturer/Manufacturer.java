package com.backend.pharmacy_management.model.entity.manufacturer;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
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
    private String manufacturerDebts;
    private String manufacturerNote ;
    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnore
    private List<ImportBill> importBills;

    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnore
    private List<ExportBill> exportBills;

    public Manufacturer() {
    }

}
