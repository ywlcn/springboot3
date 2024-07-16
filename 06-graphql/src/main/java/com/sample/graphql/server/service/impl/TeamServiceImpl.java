package com.sample.graphql.server.service.impl;

import com.sample.dto.Team;
import com.sample.graphql.server.dao.TeamDao;
import com.sample.graphql.server.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeamServiceImpl implements TeamService {


    @Autowired
    private TeamDao teamDao;

    @Override
    public Optional<Team> findById(String id) {
        return teamDao.findById(id);
    }

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }
}
