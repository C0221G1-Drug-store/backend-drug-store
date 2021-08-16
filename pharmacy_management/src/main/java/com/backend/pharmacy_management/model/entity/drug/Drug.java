package com.backend.pharmacy_management.model.entity.drug;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
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
@Table(name="drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Long drugId;
    private String drugCode;
    private String drugName;
    private String activeElement;
    private Long drugAmount;
    private String unit;
    private String conversionUnit;
    private Integer conversionRate;
    private Double wholesaleProfitRate;
    private Double retailProfitRate;
    @Column(columnDefinition = "TEXT")
    private String drugFaculty;
    private String manufacturer;
    private String origin;
    private String note;
    @Column(columnDefinition = "TEXT")
    private String drugSideEffect;
    private Boolean flag = true;
    @ManyToOne
    @JoinColumn(name = "drug_group_id")
    private DrugGroup drugGroup;
    @OneToMany(mappedBy = "drug")
    private List<DrugImageDetail> drugImageDetails;
    @OneToMany(mappedBy = "drug")
    private List<DrugOfBill> drugOfBills;
    @OneToMany(mappedBy = "drug")
    private List<Indicative> indicatives;
    @OneToMany(mappedBy = "drug")
    private List<ExportBillDetail> exportBillDetails;
}
