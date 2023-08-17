package com.example.springdemo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    int userId;
    String firstName;
    String lastName;
    @NonNull
    String nickName;
    int postsCount;
    List<Post> posts;

    public User(int userId, String firstName, String lastName, String nickName, int postsCount) {
    }

    public User(String nickName) {
        this.nickName = nickName;
    }
}
