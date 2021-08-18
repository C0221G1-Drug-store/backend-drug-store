package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.entity.user_role.User;
import com.backend.pharmacy_management.model.entity.user_role.UserRole;

import java.util.Optional;

public interface IUserRoleService {
    Optional<UserRole> findByIdUser(Long idUser);

    void save(UserRole userRole);
}
