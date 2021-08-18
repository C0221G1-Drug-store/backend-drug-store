package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.entity.user_role.Role;
import com.backend.pharmacy_management.model.repository.user.RoleReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleReposytory roleReposytory;

    @Override
    public Iterable<Role> findAll() {
        return roleReposytory.findAll();
    }
}
