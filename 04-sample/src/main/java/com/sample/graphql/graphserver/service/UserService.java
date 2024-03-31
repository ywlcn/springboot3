package com.sample.graphql.graphserver.service;

import com.sample.graphql.graphserver.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(String accountId);
    List<User> findALl();
}
