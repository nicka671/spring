package com.example.springdemo.gql;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    UserMutations userMutations;

    public UserMutations user()
    {
     return new UserMutations();
    }



}
