package com.sample.graphql.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountId;
    private String userName;
    private int age;
    private String accountType;
    private String belongingServiceGroupId;
    private String belongingTeamId;
}
