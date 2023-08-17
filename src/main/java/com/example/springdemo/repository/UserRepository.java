package com.example.springdemo.repository;

import com.example.springdemo.entities.User;
import com.example.springdemo.rowmapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getUserByNickName(String nickName ) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE nickName = ?", new Object[]{nickName}, new UserRowMapper());
    }


    public long createUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update("INSERT INTO users (nickName) VALUES (:nickName) RETURNING userId", (new MapSqlParameterSource()).addValue("nickName", user.getNickName()), keyHolder);
        return ((Number) Objects.requireNonNull(keyHolder.getKey())).longValue();
    }


}
