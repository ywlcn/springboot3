package com.sample.graphql.graphserver.dao.impl;

import com.sample.graphql.graphserver.dao.GroupDao;
import com.sample.graphql.graphserver.dao.mapper.GroupMapper;
import com.sample.graphql.graphserver.dto.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class GroupDaoImpl implements GroupDao {

    @Autowired
    GroupMapper groupMapper;

    @Override
    public Optional<Group> findById(String id) {
        return groupMapper.findById(id);
    }
}
