package com.backend.pharmacy_management.model.repository.user;

import com.backend.pharmacy_management.model.entity.user_role.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
