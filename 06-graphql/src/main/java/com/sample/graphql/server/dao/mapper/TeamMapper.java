package com.sample.graphql.server.dao.mapper;

import com.sample.dto.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
@Mapper
public interface TeamMapper {

    @Select("""
            SELECT teamId, groupId, teamName, teamAuthority
            FROM teams
            WHERE teamId = #{id}
            """)
    Optional<Team> findById(String id);
}
