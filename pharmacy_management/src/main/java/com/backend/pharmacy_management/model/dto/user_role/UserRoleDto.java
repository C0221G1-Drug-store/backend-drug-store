package com.backend.pharmacy_management.model.dto.user_role;

import com.backend.pharmacy_management.model.entity.user_role.Role;
import com.backend.pharmacy_management.model.entity.user_role.User;

public class UserRoleDto {
    private Long id;
    private Role role;
    private User user;

    public UserRoleDto(Long id, Role role, User user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }

    public UserRoleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
