package com.sample.graphql.server.dao;


import com.sample.dto.Group;
import com.sample.dto.Team;

import java.util.List;
import java.util.Optional;
public interface GroupDao {
    Optional<Group> findById(String id);

    List<Group> findAll();

}
