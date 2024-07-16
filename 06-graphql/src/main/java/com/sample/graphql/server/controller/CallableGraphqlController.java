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
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Function;

@Controller
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
        return new MyCallable(func, null);
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
        return new MyCallable(func, null);
    }

    @BatchMapping(typeName = "User", field = "team")
    public Callable<Map<User, Team>> team(List<User> users) {
        logger.info("=== BatchMapping , team. [" + users.toString() + "]=== ");
        Function func = new Function() {
            @Override
            public Object apply(Object o) {
                logger.info("--- BatchMapping Callable, team. === ");
                List<Team> teams = teamService.findAll();
                Map<User, Team> map = new HashMap<>();
                users.forEach(user -> {
                    map.put(user, teams.stream().filter(t -> t.getTeamId().equals(user.getTeamId())).findFirst().get());
                });
                return map;
            }
        };
        return new MyCallable(func, null);
    }

    @BatchMapping(typeName = "Team", field = "group")
    public Callable<Map<Team, Group>> group(List<Team> teams) {
        logger.info("=== BatchMapping , groups. [" + teams.toString() + "]=== ");
        Function func = new Function() {
            @Override
            public Object apply(Object o) {
                logger.info("--- SchemaMapping Callable, group. === ");
                List<Group> groups = groupService.findAll();
                Map<Team, Group> map = new HashMap<>();
                teams.forEach(team -> {
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    map.put(team, groups.stream().filter(t -> t.getGroupId().equals(team.getGroupId())).findFirst().get());
                });
                return map;
            }
        };
        return new MyCallable(func, null);
    }

    


}
