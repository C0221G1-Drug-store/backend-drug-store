package com.backend.pharmacy_management.model.entity.user_role;

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
@Table(name = "app_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id",nullable = false)
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    @JsonBackReference(value = "app_role-user_role")
    private List<UserRole> userRoles;
}
