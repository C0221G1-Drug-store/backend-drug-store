package com.backend.pharmacy_management.model.entity.drug;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
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
    @Column(name = "drug_amout")
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
    //    @ManyToOne
//    @JoinColumn(name = "drug_group_id")
    @Column(name = "drug_group_id")
    private String drugGroup;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "drug_image_detail-drug")
    private List<DrugImageDetail> drugImageDetails;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "drug_of_bill-drug")
    private List<DrugOfBill> drugOfBills;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "indicatives_drug-drug")
    private List<Indicative> indicatives;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "export_bill_detail-drug")
    private List<ExportBillDetail> exportBillDetails;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "import_bill_drug-drug")
    private List<ImportBillDrug> importBillDrugs;

}
