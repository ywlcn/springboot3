package com.sample.demo.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TransactionMapper {

    // 仅用于测试启动
    @Select("SELECT 1 FROM DUAL")
    int checkConnection();


    // 1. 操作 SCHEMA_A.TABLE_A
    int updateTableAStatus(@Param("id") int id, @Param("status") String status);

    // 2. 操作 SCHEMA_B.TABLE_B (跨 Schema 操作)
    // 关键：在 SQL 中使用完整的 "SCHEMA_B_USER.TABLE_B"
    int updateTableBStatus(@Param("id") int id, @Param("status") String status);

    // 查询验证 (SCHEMA_A)
    String getTableAStatus(@Param("id") int id);

    // 查询验证 (SCHEMA_B)
    String getTableBStatus(@Param("id") int id);
}