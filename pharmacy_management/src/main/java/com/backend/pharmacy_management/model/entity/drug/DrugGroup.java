package com.backend.pharmacy_management.model.entity.drug;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
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
    @JsonIgnore
    private List<Drug> drugs;
}
