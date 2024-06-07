package com.sample.graphql.server.dao;


import com.sample.dto.Group;

import java.util.Optional;
public interface GroupDao {
    Optional<Group> findById(String id);
}
