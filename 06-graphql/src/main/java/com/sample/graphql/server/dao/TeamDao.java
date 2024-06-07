package com.sample.graphql.server.dao;



import com.sample.dto.Team;

import java.util.Optional;
public interface TeamDao {

    Optional<Team> findById(String id);
}
