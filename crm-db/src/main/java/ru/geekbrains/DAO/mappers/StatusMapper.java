package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.Status;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StatusMapper implements RowMapper<Status> {

    @Override
    public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
        Status status = new Status();
        status.setId(rs.getLong("id"));
        status.setName(rs.getString("name"));
        return status;
    }
}
