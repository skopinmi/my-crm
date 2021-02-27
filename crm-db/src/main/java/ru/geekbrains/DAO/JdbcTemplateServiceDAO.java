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
    private final ServiceMapper serviceMapper;

    public Service findById(Long id) {

        String SQL = String.format("SELECT * FROM SERVICES WHERE id = %s", id);
        return jdbcTemplate.queryForObject(SQL, serviceMapper);
    }

    public List findAll() {
        String SQL = "SELECT * FROM SERVICES";
        return jdbcTemplate.query(SQL, serviceMapper);
    }

    public void deleteById (Long id) {
        String SQL = "DELETE FROM SERVICES WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
}