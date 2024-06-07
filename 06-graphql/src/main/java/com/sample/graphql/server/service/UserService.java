package com.sample.graphql.server.service;

import com.sample.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(String accountId);
    List<User> findALl();
}
