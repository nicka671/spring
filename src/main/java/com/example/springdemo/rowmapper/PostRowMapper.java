package com.example.springdemo.rowmapper;

import com.example.springdemo.entities.Post;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PostRowMapper implements RowMapper<Post> {
    public PostRowMapper() {
    }


    public Post mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Post(
                resultSet.getInt("userId"),
                resultSet.getInt("postId"),
                resultSet.getString("comment"),
                resultSet.getInt("likes"));
    }
}
