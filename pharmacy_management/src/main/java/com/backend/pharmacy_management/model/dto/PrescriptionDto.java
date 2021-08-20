package com.backend.pharmacy_management.model.dto;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
public class PrescriptionDto {
    private Long prescriptionId;
    @NotBlank(message = "Not blank")
    private String prescriptionCode;
    @NotBlank(message = "Not blank")
    private String prescriptionName;
    @NotBlank(message = "Not blank")
    private String symptom;
    @NotBlank(message = "Not blank")
    private String object;
    @NotNull(message = "Not null")
    private int numberOfDay;
    private  String note;
    private List<Indicative> indicatives;

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }


}
