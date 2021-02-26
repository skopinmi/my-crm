package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.User;
import ru.geekbrains.DAO.mappers.UserMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateUserDAO implements JdbcTemplateUser {

//    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;

//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    public User findById(Long id) {
        String SQL = String.format("SELECT * FROM USERS u join STATUSES s ON u.status_id = s.id WHERE u.id = ?", id);
        User user = (User) jdbcTemplate.queryForObject(SQL, userMapper);
        return user;
    }

    public List findAll() {
        String SQL = "SELECT * FROM USERS u join STATUSES s ON u.status_id = s.id";

//        String SQL = "SELECT * FROM USERS";
        List users = jdbcTemplate.query(SQL, userMapper);
        return users;
    }

    public void deleteById (Long id) {
        String SQL = "DELETE FROM USERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("не поддерживается");
    }
}