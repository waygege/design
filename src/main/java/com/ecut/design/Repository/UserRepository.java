package com.ecut.design.Repository;

import com.ecut.design.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
/*   @Modifying
    @Query(value = "update user u set u.user_name=?1 where u.id=?2",nativeQuery = true)
    Integer modifyByIdAndUserId(String userName,Long id);*/


    @Query(value = "select * from user_t  u where u.phone=?1 ",nativeQuery = true)
    User findByPhone (String phone);


    @Modifying
    @Transactional
    @Query(value="delete from user_t where id in (:ids)",nativeQuery = true)
    void deleteByUserIds(Long[] ids);

    @Query(value = "select * from user_t  u where u.username=?1 ",nativeQuery = true)
    User findByUsername (String username);


    @Modifying
    @Transactional
    @Query(value="update user_t set status=:status where id in (:ids)",nativeQuery = true)
    void updateByUserIds(Long[] ids,String status);




}
