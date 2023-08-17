package com.example.springdemo.gql;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class UserMutations implements GraphQLMutationResolver {

    UserCreatePostResponse userCreatePostResponse;
    UserResolver userResolver;

    public boolean createUser(String nickName)
    {
     return userResolver.createUser(nickName);
    }


    public UserCreatePostResponse createPost(UserCreatePostInput userCreatePostInput)
    {
        userResolver.createPost(userCreatePostInput.comment, userCreatePostInput.userId);
        return userCreatePostResponse = new UserCreatePostResponse();
    }

    public boolean likePost(int postId)
    {
      return userResolver.likePost(postId);
    }


}
