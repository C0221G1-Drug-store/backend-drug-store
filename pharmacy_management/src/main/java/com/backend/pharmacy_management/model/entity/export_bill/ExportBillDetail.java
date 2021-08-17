package com.backend.pharmacy_management.model.entity.export_bill;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "export_bill_detail")
public class ExportBillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillDetailId;
    @ManyToOne
    @JoinColumn(name = "export_bill_id")
//    @JsonManagedReference
    private ExportBill exportBill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
//    @JsonManagedReference
    private Drug drug;
}
