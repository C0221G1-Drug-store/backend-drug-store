package com.backend.pharmacy_management.model.entity.export_bill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "export_bill_type")
public class ExportBillType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillTypeId;
    private String exportBillTypeName;

    @OneToMany(mappedBy = "exportBillType")
    @JsonIgnore
    private List<ExportBill> exportBills;

    public ExportBillType() {
    }

}
