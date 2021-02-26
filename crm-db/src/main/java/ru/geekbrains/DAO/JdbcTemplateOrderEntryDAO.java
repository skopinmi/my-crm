package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.OrderEntry;
import ru.geekbrains.DAO.mappers.OrderEntryMapper;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateOrderEntryDAO {

    private final JdbcTemplate jdbcTemplate;

    public OrderEntry findById(Long id) {
        String SQL = "SELECT * FROM ORDER_ENTERY oe join ORDERS o ON oe.order_id = o.id join SERVICES s ON oe.service_id = s.id join USERS u ON o.user_id = u.id  WHERE id = " + id;
        OrderEntry orderEntry = (OrderEntry) jdbcTemplate.queryForObject(SQL, new OrderEntryMapper());
        return orderEntry;
    }

    public List findAll() {
        String SQL = "SELECT * FROM ORDER_ENTERY oe join ORDERS o ON oe.order_id = o.id join SERVICES s ON oe.service_id = s.id join USERS u ON o.user_id = u.id";
        List orderEntry = jdbcTemplate.query(SQL, new OrderEntryMapper());
        return orderEntry;
    }

    public List findAllByOrderId(Long id) {
        String SQL = "SELECT * FROM ORDER_ENTERY oe join ORDERS o ON oe.order_id = o.id join SERVICES s ON oe.service_id = s.id join USERS u ON o.user_id = u.id WHERE o.id = " + id;
        List orderEntry = jdbcTemplate.query(SQL, new OrderEntryMapper());
        return orderEntry;
    }

    public void deleteById(Long id) {
        String SQL = "DELETE FROM ORDER_ENTERY WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
}