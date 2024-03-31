package com.sample.graphql.graphserver.dao;

import com.sample.graphql.graphserver.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findById(String userId);

    Optional<List<User>> findAll();
}



