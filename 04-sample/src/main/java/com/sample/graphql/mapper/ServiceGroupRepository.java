package com.sample.graphql.mapper;

import com.sample.graphql.dao.ServiceGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface ServiceGroupRepository {

    @Select("""
            SELECT service_group_id, service_group_name
            FROM service_group
            WHERE service_group_id = #{id}
            """)
    Optional<ServiceGroup> findById(String id);
}