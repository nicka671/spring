package com.example.springdemo.gql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    UserQueries userQueries;

    public UserQueries user()
    {
     return new UserQueries();
    }



}
