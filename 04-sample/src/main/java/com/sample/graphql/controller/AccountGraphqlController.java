package com.sample.graphql.controller;

import com.sample.graphql.dao.Account;
import com.sample.graphql.dao.ServiceGroup;
import com.sample.graphql.dao.Team;
import com.sample.graphql.mapper.AccountRepository;
import com.sample.graphql.mapper.ServiceGroupRepository;
import com.sample.graphql.mapper.TeamRepository;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

//@Observed(name = "GraphqlController")
@Controller
public class AccountGraphqlController {

    private final Logger logger = LoggerFactory.getLogger(AccountGraphqlController.class);

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ServiceGroupRepository serviceGroupRepository;
    @Autowired
    private TeamRepository teamRepository;

    @QueryMapping
    public Account accountById(@Argument final String accountId) {
        logger.info("=== Query Call, queryByAccountId. === ");
        final Optional<Account> acc = accountRepository.findById(accountId);
        return acc.get();
    }

    @SchemaMapping
    public ServiceGroup serviceGroup(final Account account) {
        final Optional<ServiceGroup> sg = serviceGroupRepository.findById(account.getBelongingServiceGroupId());
        return sg.get();
    }

    @SchemaMapping
    public Team team(final Account account) {
        final Optional<Team> t = teamRepository.findById(account.getBelongingTeamId());
        return t.get();
    }

    @SchemaMapping
    public ServiceGroup serviceGroup(final Team team) {
        final Optional<ServiceGroup> sg = serviceGroupRepository.findById(team.getBelongingServiceGroupId());
        return sg.get();
    }
}
