package com.sample.graphql.server.service;

import com.sample.dto.Team;

import java.util.Optional;

public interface TeamService {
    Optional<Team> findById(String id);
}
