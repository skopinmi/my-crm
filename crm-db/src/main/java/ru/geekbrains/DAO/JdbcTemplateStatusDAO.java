package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.Status;
import ru.geekbrains.DAO.mappers.StatusMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateStatusDAO {

    private final JdbcTemplate jdbcTemplate;
    private final StatusMapper statusMapper;

    public Status findById(Long id) {
        String SQL = "SELECT * FROM STATUSES WHERE id = ?";
        return (Status) jdbcTemplate.query(SQL, statusMapper);
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
