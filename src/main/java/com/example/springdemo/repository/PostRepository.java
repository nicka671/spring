package com.example.springdemo.repository;

import com.example.springdemo.entities.Post;
import com.example.springdemo.rowmapper.PostRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PostRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PostRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Post getPost(int postId) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM posts WHERE postId = :postId",
                (SqlParameterSource) new MapSqlParameterSource().addValue("postId", postId), Post.class);
    }


    public List<Post> getUserPosts(int userId) {
        return this.jdbcTemplate.query("SELECT * FROM posts WHERE userId = :userId",
                (SqlParameterSource) new MapSqlParameterSource().addValue("userId", userId), new PostRowMapper());
    }


    public long createPost(Post post, int userId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update("INSERT INTO posts (userId, created, comments, likes) VALUES (:userId, :created, :comments, 0) RETURNING postId", (new MapSqlParameterSource()).addValue("user_id", userId).addValue("comment", post.getComment()), keyHolder);
        return ((Number) Objects.requireNonNull(keyHolder.getKey())).longValue();
    }

    public void likePost(Post postToLike) {
        int postId = postToLike.getPostId();
        this.jdbcTemplate.update("UPDATE posts SET likes = :likes WHERE postId = :postId ", (new MapSqlParameterSource()).addValue("likes", postToLike.getLikes()));
    }


}
