package com.sample.graphql.graphserver.service;

import com.sample.graphql.graphserver.dto.Team;

import java.util.Optional;

public interface TeamService {
    Optional<Team> findById(String id);
}
