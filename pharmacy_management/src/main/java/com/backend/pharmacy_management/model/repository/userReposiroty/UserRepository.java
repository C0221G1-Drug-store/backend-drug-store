package com.backend.pharmacy_management.model.repository.userReposiroty;


import com.backend.pharmacy_management.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

    Boolean existsByUserName(String username);

    @Query(value = "select count(*) from users where user_code like '%k%'",nativeQuery = true)
    int totalOfRecordKH();
}
