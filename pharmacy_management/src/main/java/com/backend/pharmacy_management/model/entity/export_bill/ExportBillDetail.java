package com.backend.pharmacy_management.model.entity.export_bill;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "export_bill_detail")
public class ExportBillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillDetailId;
    @ManyToOne
    @JoinColumn(name = "export_bill_id")
    private ExportBill exportBill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
}
