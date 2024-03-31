package com.sample.graphql.graphserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String userName;
    private int age;
    private String accountType;
    private String teamId;
    private Team team;
}
