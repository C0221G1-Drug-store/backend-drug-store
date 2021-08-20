package com.backend.pharmacy_management.model.entity.indicative_prescription;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity

@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private String prescriptionCode;
    private String prescriptionName;
    private String symptom;
    private String object;
    private int numberOfDay;
    private  String note;
    private  boolean flag;

    @JsonBackReference
    @OneToMany(mappedBy = "prescription")
    private List<Indicative> indicatives;

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Indicative> getIndicatives() {
        return indicatives;
    }

}
