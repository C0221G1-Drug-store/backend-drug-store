package com.backend.pharmacy_management.model.entity.user_role;
<<<<<<< HEAD

=======
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
>>>>>>> client
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id",nullable = false)
    @JsonManagedReference
    private Long roleId;
    @Column(name = "role_name")
    @JsonManagedReference
    private String roleName;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<UserRole> userRoles;
}
