package com.backend.pharmacy_management.model.entity.drug;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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

    public DrugGroup() {
    }

}
