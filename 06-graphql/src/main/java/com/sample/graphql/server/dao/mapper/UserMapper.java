package com.sample.graphql.server.dao.mapper;

import com.sample.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("""
            SELECT userId, userName, age, teamId
            FROM users
            WHERE userId = #{userId}
            """)
    Optional<User> findById(String userId);


    @Select("""
            SELECT userId, userName, age, teamId
            FROM users
            """)
    List<User> findAll();
}



