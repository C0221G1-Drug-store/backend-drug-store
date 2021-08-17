package com.backend.pharmacy_management.model.entity.user_role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
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
    private Role role;
    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user;
}
