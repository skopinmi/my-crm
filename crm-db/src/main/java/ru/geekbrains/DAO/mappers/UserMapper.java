package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.geekbrains.models.Status;
import ru.geekbrains.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println();
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setDescription(rs.getString("description"));
        Status status = new Status();
        status.setId(rs.getLong("s.id"));
        status.setName(rs.getString("s.name"));
        user.setStatus(status);
        return user;
    }
}
