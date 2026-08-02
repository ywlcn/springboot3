package com.example.demo.dao.mapper;

import com.example.demo.dao.dto.CityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CityMapper {


    @Select("SELECT * from city where id = #{id}")
    CityEntity getCity(@Param("id") int id);


}
