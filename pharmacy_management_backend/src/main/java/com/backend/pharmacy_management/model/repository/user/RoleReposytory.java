package com.backend.pharmacy_management.model.repository.user;

import com.backend.pharmacy_management.model.entity.user_role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReposytory extends JpaRepository<Role,Integer> {
}
