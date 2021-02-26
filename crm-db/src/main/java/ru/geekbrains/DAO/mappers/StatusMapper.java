package ru.geekbrains.DAO.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.geekbrains.DAO.JdbcTemplateUserDAO;
import ru.geekbrains.models.Status;
import ru.geekbrains.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
//@RequiredArgsConstructor
public class StatusMapper implements RowMapper {

    @Override
    public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
        Status status = new Status();
        status.setId(rs.getLong("id"));
        status.setName(rs.getString("name"));
//        status.setUsers((List<User>)rs.getObject("users"));
        return status;
    }
}
