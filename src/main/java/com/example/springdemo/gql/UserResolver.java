package com.example.springdemo.gql;

import com.example.springdemo.entities.Post;
import com.example.springdemo.repository.PostRepository;
import com.example.springdemo.entities.User;
import com.example.springdemo.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver implements GraphQLQueryResolver {

    User user;
    PostRepository postRepository;
    UserRepository userRepository;

    boolean createUser(String nickName) {
        if (userRepository.getUserByNickName(nickName) == null) {
            User user = new User(nickName);
            userRepository.createUser(user);
            return true;
        }
        return false;
    }

    List<Post> getUserPosts(int userId) {
        return postRepository.getUserPosts(userId);
    }

    boolean createPost(String comment, int user_id) {
        if (comment.isBlank() || comment.isEmpty())
        {
            return false;
        }
        else {
            Post post = new Post(comment, user_id);
             postRepository.createPost(post, user_id);
             return true;
        }
    }

    boolean likePost(int postId) {
        if (postRepository.getPost(postId) == null) {
            return false;
        } else {
            Post postToLike = postRepository.getPost(postId);
            postToLike.setLikes(postToLike.getLikes() + 1);
            postRepository.likePost(postToLike);
            return true;
        }
    }
}
