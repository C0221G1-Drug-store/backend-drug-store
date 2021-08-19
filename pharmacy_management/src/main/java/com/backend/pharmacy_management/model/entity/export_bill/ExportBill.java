package com.backend.pharmacy_management.model.entity.export_bill;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "export_bill")
public class ExportBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillId;
    private String exportBillCode;
    private String exportBillIdDate;
    private String exportBillReason;
    private String exportBillIdAddress;
    private boolean flag;
    @ManyToOne
    @JoinColumn(name = "export_bill_type_id")
    private ExportBillType exportBillType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "exportBill")
    private Set<ExportBillDetail> exportBillDetails;
}