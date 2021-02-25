package ru.geekbrains.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.geekbrains.models.Status;
import ru.geekbrains.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
