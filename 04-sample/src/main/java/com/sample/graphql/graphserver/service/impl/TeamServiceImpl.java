package com.sample.graphql.graphserver.service.impl;

import com.sample.graphql.graphserver.dao.TeamDao;
import com.sample.graphql.graphserver.dto.Team;
import com.sample.graphql.graphserver.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeamServiceImpl implements TeamService {


    @Autowired
    private TeamDao teamDao;

    @Override
    public Optional<Team> findById(String id) {
        return teamDao.findById(id);
    }
}
