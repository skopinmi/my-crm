package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.geekbrains.DAO.mappers.OrderMapper;
import ru.geekbrains.models.Order;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateOrderDAO {

    private final JdbcTemplate jdbcTemplate;
    private final OrderMapper orderMapper;

    public Order findById(Long id) {
        String SQL = String.format("SELECT * FROM ORDERS o JOIN USERS u ON o.user_id = u.id WHERE o.id = %s", id);
        return jdbcTemplate.queryForObject(SQL, orderMapper);
    }

    public List findAll() {
        String SQL = "SELECT * FROM ORDERS o JOIN USERS u ON o.user_id = u.id";
        return jdbcTemplate.query(SQL, orderMapper);
    }

    public void deleteById (Long id) {
        String SQL = "DELETE FROM ORDERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

}