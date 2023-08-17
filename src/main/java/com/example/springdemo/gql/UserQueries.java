package com.example.springdemo.gql;

import com.example.springdemo.entities.Post;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQueries implements GraphQLMutationResolver {

    UserResolver userResolver;

    public List<Post> getUserPosts(int userId)
    {
     return userResolver.getUserPosts(userId);
    }


}
