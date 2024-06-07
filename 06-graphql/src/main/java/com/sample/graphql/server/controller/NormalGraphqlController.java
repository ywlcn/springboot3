package com.sample.graphql.server.controller;

import com.sample.dto.Group;
import com.sample.dto.Team;
import com.sample.dto.User;
import com.sample.graphql.server.service.GroupService;
import com.sample.graphql.server.service.TeamService;
import com.sample.graphql.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class NormalGraphqlController {

    private final Logger logger = LoggerFactory.getLogger(NormalGraphqlController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeamService teamService;

    @QueryMapping
    public User userById(@Argument final String userId) {
        logger.info("=== QueryMapping Call, queryByUserId. [" + userId + "]=== ");
        final Optional<User> acc = userService.findById(userId);
        return acc.get();
    }

    @QueryMapping
    public List<User> users() {
        logger.info("=== QueryMapping Call, queryUsers. === ");
        return userService.findALl();
    }

    @SchemaMapping(typeName = "User", field = "team")
    public Team team(final User user) {
        logger.info("=== SchemaMapping Call, team. [" + user.getUserId() + "]=== ");
        final Optional<Team> t = teamService.findById(user.getTeamId());
        return t.get();
    }

    @SchemaMapping(typeName = "Team", field = "group")
    public Group group(final Team team) {
        logger.info("=== SchemaMapping Call, group. [" + team.getGroupId() + "]=== ");
        final Optional<Group> sg = groupService.findById(team.getGroupId());
        return sg.get();
    }



}
