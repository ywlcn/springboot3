package com.sample.graphql.server.service;

import com.sample.dto.Group;
import com.sample.dto.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<Team> findById(String id);

    List<Team> findAll();
}
