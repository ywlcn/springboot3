package com.sample.graphql.server.dao.impl;

import com.sample.dto.User;
import com.sample.graphql.server.dao.TeamDao;
import com.sample.graphql.server.dao.mapper.TeamMapper;
import com.sample.dto.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class TeamDaoImpl implements TeamDao {

    @Autowired
    TeamMapper teamMapper;

    @Override
    public Optional<Team> findById(String id) {
        return teamMapper.findById(id);
    }
    @Override
    public List<Team> findAll() {
        return teamMapper.findAll();
    }
}
