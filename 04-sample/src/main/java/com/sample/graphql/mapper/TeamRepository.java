package com.sample.graphql.mapper;

import com.sample.graphql.dao.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TeamRepository {

    @Select("""
            SELECT team_id, belonging_service_group_id, team_name, team_authority
            FROM team
            WHERE team_id = #{id}
            """)
    Optional<Team> findById(String id);

}