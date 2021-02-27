package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ServiceMapper implements RowMapper <Service>{

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
