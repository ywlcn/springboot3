package com.sample.graphql.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceGroup {
    private String serviceGroupId;
    private String serviceGroupName;
}
