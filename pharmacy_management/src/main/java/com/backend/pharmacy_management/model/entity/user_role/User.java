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
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "encryted_password")
    private String encrytedPassword;
    @Column(name = "enabled")
    private String enabled;
    @OneToMany(mappedBy = "user")
    @JsonBackReference(value = "app_user-user_role")
    private List<UserRole> userRoles;
}
