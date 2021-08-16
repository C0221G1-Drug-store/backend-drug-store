package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.entity.user_role.User;
import com.backend.pharmacy_management.model.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> findAllByProperty(Pageable pageable, String keyWord, String property) {
        return null;
    }

    @Override
    public Iterable<User> findAllNoPage() {
        return userRepository.findAll();
    }
}
