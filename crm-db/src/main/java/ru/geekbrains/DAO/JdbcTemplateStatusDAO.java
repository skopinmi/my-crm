package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.Status;
import ru.geekbrains.DAO.mappers.StatusMapper;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateStatusDAO {

    private final JdbcTemplate jdbcTemplate;
    private final StatusMapper statusMapper;

    public Status findById(Long id) {
        String SQL = String.format("SELECT * FROM STATUSES WHERE id = %s", id);
        return jdbcTemplate.queryForObject(SQL, statusMapper);
    }

    public List findAll() {
        String SQL = "SELECT * FROM STATUSES";
        return jdbcTemplate.query(SQL, statusMapper);
    }

    public void deleteById (Long id) {
        String SQL = "DELETE FROM STATUSES WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
}
