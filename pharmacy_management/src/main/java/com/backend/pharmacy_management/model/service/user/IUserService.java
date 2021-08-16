package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.entity.user_role.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    Optional<User> findById(Long id);

    void save(User user);

    Page<User> findAllByProperty(Pageable pageable,String keyWord,String property);

    Iterable<User> findAllNoPage();
}
