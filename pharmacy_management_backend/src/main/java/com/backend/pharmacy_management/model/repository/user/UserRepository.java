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
    @Query(value="select * from users inner join user_roles on users.id = user_roles.user_id inner join roles on roles.id = user_roles.role_id where (:para2 = 1 AND user_name like :para1) OR (:para2 = 3 AND account_name like :para1) OR (:para2 = 2 AND user_code like :para1) OR (:para2 = 4 AND roles.id = :para3) OR (:para2 = 0) order by account_name,user_name,user_code,roles.name",nativeQuery=true)
    Page<User> findAllUserByProperty(Pageable pageable, @Param("para1") String keyWord, @Param("para2") Long property,@Param("para3") Integer roleId);

    User findByAccountName(String username);

}
