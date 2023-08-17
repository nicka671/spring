package com.example.springdemo.rowmapper;

import com.example.springdemo.entities.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {
    public UserRowMapper() {
    }


    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new User(
                resultSet.getInt("userId"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("nickName"),
                resultSet.getInt("postsCount"));
                //чд если у меня лист?
    }
}

