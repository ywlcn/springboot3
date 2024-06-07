package com.sample.graphql.server.service;

import com.sample.dto.Group;

import java.util.Optional;

public interface GroupService {
    Optional<Group> findById(String id);
}
