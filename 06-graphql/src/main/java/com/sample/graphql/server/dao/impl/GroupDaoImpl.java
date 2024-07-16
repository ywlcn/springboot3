package com.sample.graphql.server.dao.impl;

import com.sample.dto.Team;
import com.sample.graphql.server.dao.GroupDao;
import com.sample.graphql.server.dao.mapper.GroupMapper;
import com.sample.dto.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class GroupDaoImpl implements GroupDao {

    @Autowired
    GroupMapper groupMapper;

    @Override
    public Optional<Group> findById(String id) {
        return groupMapper.findById(id);
    }
    @Override
    public List<Group> findAll() {
        return groupMapper.findAll();
    }
}
