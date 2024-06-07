package com.sample.graphql.server.dao.mapper;

import com.sample.dto.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface GroupMapper {
    @Select("""
            SELECT groupId, groupName
            FROM groups
            WHERE groupId = #{id}
            """)
    Optional<Group> findById(String id);
}
