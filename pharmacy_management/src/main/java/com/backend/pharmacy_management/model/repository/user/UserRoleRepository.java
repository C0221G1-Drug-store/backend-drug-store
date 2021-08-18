package com.backend.pharmacy_management.model.repository.user;

import com.backend.pharmacy_management.model.entity.user_role.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    @Query(value="select * from user_role where user_role.user_id = :para",nativeQuery=true)
    Optional<UserRole> findByIdUser(@Param("para") Long idUser);
}
