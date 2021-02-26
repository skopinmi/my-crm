package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.Service;
import ru.geekbrains.DAO.mappers.ServiceMapper;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateServiceDAO {

    private final  JdbcTemplate jdbcTemplate;

    public Service findById(Long id) {
        String SQL = "SELECT * FROM SERVICES WHERE id = ?";
        Service service = (Service) jdbcTemplate.queryForObject(SQL, new ServiceMapper());
        return service;
    }

    public List findAll() {
        String SQL = "SELECT * FROM SERVICES";
        List services = jdbcTemplate.query(SQL, new ServiceMapper());
        return services;
    }

    public void deleteById (Long id) {
        String SQL = "DELETE FROM SERVICES WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
}