package com.sample.graphql.server.service.impl;

import com.sample.dto.Group;
import com.sample.graphql.server.dao.GroupDao;
import com.sample.graphql.server.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Component
public class GroupServiceImpl implements GroupService {


    @Autowired
    private GroupDao groupDao;


    @Override
    public Optional<Group> findById(String id) {
        return groupDao.findById(id);
    }


    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }
}
