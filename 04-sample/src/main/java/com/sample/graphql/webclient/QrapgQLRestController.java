package com.sample.graphql.webclient;

import com.sample.graphql.graphserver.dto.User;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;

@RequestMapping("/rest/graphql")
@RestController
public class QrapgQLRestController {

    private final HttpGraphQlClient graphQlClient;

    public QrapgQLRestController() {
        WebClient client = WebClient.builder().baseUrl("http://localhost:8080/graphql").build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }


    //@RequestMapping("/account/${id}")
    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUser(@RequestParam(value = "id", defaultValue = "001") String id) {
        String document = """
                query {
                    userById(userId: "001") {
                        userId
                        userName
                        age
                        accountType
                        team {
                            teamId
                            teamName
                            teamAuthority
                            group {
                                groupId
                                groupName
                            }
                        }
                    }
                }
                """;
        Mono<User> user = graphQlClient.document(document)
                .retrieve("userById").toEntity(User.class);
        User t = user.block();
        return t;
    }


    @RequestMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        String document = """
                query {
                    users {
                        userId
                        userName
                        age
                        accountType
                        team {
                            teamId
                            teamName
                            teamAuthority
                            group {
                                groupId
                                groupName
                            }
                        }
                    }
                }
                """;
        Mono<List<User>> users = graphQlClient.document(document)
                .retrieve("users").toEntityList(User.class);
        return users.block();
    }

}
