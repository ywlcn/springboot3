package com.sample.graphql.graphserver.dao;

import com.sample.graphql.graphserver.dto.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
public interface GroupDao {
    Optional<Group> findById(String id);
}
