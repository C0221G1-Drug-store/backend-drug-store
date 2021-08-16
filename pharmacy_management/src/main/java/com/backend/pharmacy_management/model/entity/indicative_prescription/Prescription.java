package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
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
    @JsonManagedReference(value = "prescription-prescription_indicative")
    @OneToMany(mappedBy = "prescription")
    private Set<PrescriptionIndicative> prescriptionIndicatives;
    @JsonManagedReference(value = "drug_of_bill-prescription_indicative")
    @OneToMany(mappedBy = "prescription")
    private Set<DrugOfBill> drugOfBills;
}
