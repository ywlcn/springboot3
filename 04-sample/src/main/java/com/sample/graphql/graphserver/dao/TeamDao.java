package com.sample.graphql.graphserver.dao;

import com.sample.graphql.graphserver.dto.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
public interface TeamDao {

    Optional<Team> findById(String id);
}
