package com.backend.pharmacy_management.model.entity.user_role;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
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
//    @JsonManagedReference
    private Role role;
    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
//    @JsonManagedReference
    private User user;
}
