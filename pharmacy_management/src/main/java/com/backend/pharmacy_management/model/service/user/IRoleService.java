package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.entity.user_role.Role;
import com.backend.pharmacy_management.model.entity.user_role.User;

public interface IRoleService {
    Iterable<Role> findAll();
}
