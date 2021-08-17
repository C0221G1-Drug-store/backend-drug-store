package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
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
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;  // id đơn thuốc
    private String prescriptionCode;  // mã code
    private String prescriptionName;   // tên đơn thuốc
    private String symptom;    // triệu chứng
    private String object;     // đối tượng uống thuốc
    private int numberOfDay;  // số ngày uống
    private  String note;  //  ghi chú
    @JsonBackReference(value = "prescription-prescription_indicative")
    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionIndicative> prescriptionIndicatives;
    @JsonBackReference(value = "drug_of_bill-prescription_indicative")
    @OneToMany(mappedBy = "prescription")
    private List<DrugOfBill> drugOfBills;
}
