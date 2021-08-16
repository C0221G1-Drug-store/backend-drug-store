package com.backend.pharmacy_management.model.repository.user;

import com.backend.pharmacy_management.model.entity.user_role.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {
}
