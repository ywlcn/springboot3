package com.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private String teamId;
    private String groupId;
    private String teamName;
    private String teamAuthority;
    private Group group;
}