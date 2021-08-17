package com.backend.pharmacy_management.model.entity.drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="drug_group")
public class DrugGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugGroupId;
    private String drugGroupCode;
    private String drugGroupName;
    @OneToMany(mappedBy = "drugGroup")
//    @JsonBackReference
    private List<Drug> drugs;
}
