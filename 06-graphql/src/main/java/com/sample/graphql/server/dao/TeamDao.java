package com.sample.graphql.server.dao;



import com.sample.dto.Team;
import com.sample.dto.User;

import java.util.List;
import java.util.Optional;
public interface TeamDao {

    Optional<Team> findById(String id);

    List<Team> findAll();
}
