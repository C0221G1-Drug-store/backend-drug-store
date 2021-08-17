package com.backend.pharmacy_management.model.entity.export_bill;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "export_bill")
public class ExportBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillId;
    private String exportBillCode;
    private String exportBillDate;
    private String exportBillReason;
    private String exportBillAddress;
    private boolean flag;
    @ManyToOne
    @JoinColumn(name = "export_bill_type_id")
    private ExportBillType exportBillType;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "exportBill", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExportBillDetail> exportBillDetails;

    public ExportBill() {
    }

}