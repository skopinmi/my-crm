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

    public Order findById(Long id) {
        String SQL = "SELECT * FROM ORDERS WHERE id = ?";
        Order order = (Order) jdbcTemplate.queryForObject(SQL, new Object[] {id}, new OrderMapper());
        return order;
    }

    public List findAll() {
        String SQL = "SELECT * FROM ORDERS o JOIN USERS u ON o.user_id = u.id";
        List orders = jdbcTemplate.query(SQL, new OrderMapper());
        return orders;
    }

    public void deleteById (Long id) {
        String SQL = "DELETE FROM ORDERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

}