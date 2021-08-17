package com.backend.pharmacy_management.model.entity.user_role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "role_id")
    @JsonBackReference(value = "app_role-user_role")
    private Role role;
    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    @JsonBackReference(value = "app_user-user_role")
    private User user;
}
