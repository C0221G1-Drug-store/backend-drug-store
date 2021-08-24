package com.backend.pharmacy_management.model.entity.export_bill;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @JsonBackReference
    private ExportBillType exportBillType;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonBackReference(value = "manufacturer-export_bill")
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "exportBill")
    @JsonManagedReference(value = "export_bill_detail-export_bill")
    private List<ExportBillDetail> exportBillDetails;
}