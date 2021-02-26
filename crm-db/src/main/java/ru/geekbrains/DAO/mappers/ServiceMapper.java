package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.geekbrains.models.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper {

    @Override
    public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
        Service service = new Service();
        service.setId(rs.getLong("id"));
        service.setName(rs.getString("name"));
        service.setDescription(rs.getString("description"));
        service.setPrice(rs.getBigDecimal("price"));
        return service;
    }
}
