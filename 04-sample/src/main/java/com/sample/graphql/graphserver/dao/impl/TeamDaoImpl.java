package com.sample.graphql.graphserver.dao.impl;

import com.sample.graphql.graphserver.dao.TeamDao;
import com.sample.graphql.graphserver.dao.mapper.GroupMapper;
import com.sample.graphql.graphserver.dao.mapper.TeamMapper;
import com.sample.graphql.graphserver.dto.Group;
import com.sample.graphql.graphserver.dto.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class TeamDaoImpl implements TeamDao {

    @Autowired
    TeamMapper teamMapper;

    @Override
    public Optional<Team> findById(String id) {
        return teamMapper.findById(id);
    }
}
