package com.backend.pharmacy_management.model.entity.export_bill;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String exportBillDate;
    private String exportBillReason;
    private String exportBillAddress;
    private Boolean flag=true;
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
    @JsonIgnore
    private List<ExportBillDetail> exportBillDetails;


}