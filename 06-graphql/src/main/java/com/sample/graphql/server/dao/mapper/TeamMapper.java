package com.sample.graphql.server.dao.mapper;

import com.sample.dto.Group;
import com.sample.dto.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
@Mapper
public interface TeamMapper {

    @Select("""
            SELECT teamId, groupId, teamName, teamAuthority
            FROM teams
            WHERE teamId = #{id}
            """)
    Optional<Team> findById(String id);


    @Select("""
            SELECT teamId, groupId, teamName, teamAuthority
            FROM teams
            """)
    List<Team> findAll();
}
