package com.sample.graphql.mapper;

import com.sample.graphql.dao.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface AccountRepository {

    @Select("""
            SELECT account_id, user_name, age, belonging_service_group_id , belonging_team_id
            FROM account
            WHERE account_id = '001'
            """)  // #{accountId}
    Optional<Account>  findById(String accountId);

}