package com.backend.pharmacy_management.model.entity.export_bill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "export_bill_detail")
public class ExportBillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exportBillDetailId;

    @ManyToOne
    @JoinColumn(name = "export_bill_id")
    private ExportBill exportBill;

    @OneToOne
    @JoinColumn(name = "import_bill_drug_id")
    private ImportBillDrug importBillDrug;

    public ExportBillDetail() {
    }
}
