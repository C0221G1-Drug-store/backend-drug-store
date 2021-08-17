package com.backend.pharmacy_management.model.repository.user;

import com.backend.pharmacy_management.model.entity.user_role.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    @Query(value="select * from app_user inner join user_role on app_user.user_id = user_role.user_id inner join app_role on app_role.role_id = user_role.role_id where (:para2 = 1 AND user_name like :para1) OR (:para2 = 3 AND account_name like :para1) OR (:para2 = 2 AND user_code like :para1) OR (:para2 = 4 AND app_role.role_name like :para1) OR (:para2 = 0)",nativeQuery=true)
    Page<User> findAllUserByProperty(Pageable pageable, @Param("para1") String keyWord, @Param("para2") Long property);
}
