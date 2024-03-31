package com.sample.graphql.graphserver.dao.mapper;

import com.sample.graphql.graphserver.dto.Group;
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
