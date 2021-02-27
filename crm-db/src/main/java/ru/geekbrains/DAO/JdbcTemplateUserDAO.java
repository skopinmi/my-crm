package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.User;
import ru.geekbrains.DAO.mappers.UserMapper;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateUserDAO {

    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;


    public User findById(Long id) {
        String SQL = String.format("SELECT * FROM USERS u join STATUSES s ON u.status_id = s.id WHERE u.id = %s", id);
        return jdbcTemplate.queryForObject(SQL, userMapper);
    }

    public List findAll() {
        String SQL = "SELECT * FROM USERS u join STATUSES s ON u.status_id = s.id";
        return jdbcTemplate.query(SQL, userMapper);
    }

    public void deleteById (Long id) {
        String SQL = "DELETE FROM USERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

}