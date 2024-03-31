package com.sample.graphql.graphserver.service;

import com.sample.graphql.graphserver.dto.Group;

import java.util.Optional;

public interface GroupService {
    Optional<Group> findById(String id);
}
