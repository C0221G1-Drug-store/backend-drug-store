package com.backend.pharmacy_management.model.entity.export_bill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "export_bill_type")
public class ExportBillType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillTypeId;
    private String exportBillTypeName;
    @OneToMany(mappedBy = "exportBillType")
    private Set<ExportBill> exportBills;
}
