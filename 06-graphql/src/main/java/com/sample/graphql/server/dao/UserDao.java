package com.sample.graphql.server.dao;


import com.sample.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findById(String userId);

    List<User> findAll();
}



