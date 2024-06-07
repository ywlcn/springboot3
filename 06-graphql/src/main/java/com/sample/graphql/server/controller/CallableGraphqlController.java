package com.sample.graphql.server.controller;

import com.sample.dto.Group;
import com.sample.dto.Team;
import com.sample.dto.User;
import com.sample.graphql.server.controller.internal.MyCallable;
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
import java.util.concurrent.Callable;
import java.util.function.Function;

//@Controller
public class CallableGraphqlController {

    private final Logger logger = LoggerFactory.getLogger(CallableGraphqlController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeamService teamService;

    @QueryMapping
    public Callable<User> userById(@Argument final String userId) {
        logger.info("=== QueryMapping , userById. [" + userId + "]=== ");
        Function func = new Function() {
            @Override
            public Object apply(Object o) {
                logger.info("--- QueryMapping Callable, userById. [" + userId + "]=== ");
                final Optional<User> acc = userService.findById(userId);
                return acc.get();
            }
        };
        return new MyCallable(func , null);
    }

    @QueryMapping
    public Callable<List<User>> users() {
        logger.info("=== QueryMapping , users.=== ");
        Function func = new Function() {
            @Override
            public Object apply(Object o) {
                logger.info("--- QueryMapping Callable, users. === ");
                return userService.findALl();
            }
        };
        return new MyCallable(func , null);
    }

    @SchemaMapping(typeName = "User", field = "team")
    public Callable<Team> team(final User user) {
        logger.info("=== SchemaMapping , team. [" + user.getTeamId() + "]=== ");
        Function func = new Function() {
            @Override
            public Object apply(Object o) {
                logger.info("--- SchemaMapping Callable, team. === ");
                final Optional<Team> t = teamService.findById(user.getTeamId());
                return t.get();
            }
        };
        return new MyCallable(func , null);


    }

    @SchemaMapping(typeName = "Team", field = "group")
    public Callable<Group> group(final Team team) {
        logger.info("=== SchemaMapping , group. [" + team.getGroupId() + "]=== ");
        Function func = new Function() {
            @Override
            public Object apply(Object o) {
                logger.info("--- SchemaMapping Callable, group. === ");
                final Optional<Group> sg = groupService.findById(team.getGroupId());
                return sg.get();
            }
        };
        return new MyCallable(func , null);


    }


}
