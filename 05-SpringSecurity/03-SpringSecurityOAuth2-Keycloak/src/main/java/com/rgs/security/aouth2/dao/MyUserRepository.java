package com.rgs.security.aouth2.dao;

import com.rgs.security.aouth2.service.dto.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    @Query(value = "select * from moneyhome_main.auth_user where USER_NAME = :userName ", nativeQuery = true)
    MyUser findByName(@Param("userName") String userName);

}
