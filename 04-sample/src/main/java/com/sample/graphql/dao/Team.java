package com.sample.graphql.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private String teamId;
    private String belongingServiceGroupId;
    private String teamName;
    private String teamAuthority;
}