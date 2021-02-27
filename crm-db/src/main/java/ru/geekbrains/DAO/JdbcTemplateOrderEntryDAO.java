package ru.geekbrains.DAO;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.models.OrderEntry;
import ru.geekbrains.DAO.mappers.OrderEntryMapper;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcTemplateOrderEntryDAO {

    private final JdbcTemplate jdbcTemplate;
    private final OrderEntryMapper orderEntryMapper;

    public OrderEntry findById(Long id) {

        String SQL = String.format("SELECT * FROM ORDER_ENTRY oe join ORDERS o ON oe.order_id = o.id join SERVICES s ON oe.service_id = s.id join USERS u ON o.user_id = u.id  WHERE id = %s", id);
        return jdbcTemplate.queryForObject(SQL, orderEntryMapper);
    }

    public List findAll() {
        String SQL = "SELECT * FROM ORDER_ENTRY oe join ORDERS o ON oe.order_id = o.id join SERVICES s ON oe.service_id = s.id join USERS u ON o.user_id = u.id";
        return jdbcTemplate.query(SQL, orderEntryMapper);
    }

    public List findAllByOrderId(Long id) {
        String SQL = String.format("SELECT * FROM ORDER_ENTRY oe join ORDERS o ON oe.order_id = o.id join SERVICES s ON oe.service_id = s.id join USERS u ON o.user_id = u.id WHERE oe.order_id =  %s", id);
        return jdbcTemplate.query(SQL, orderEntryMapper);
    }

    public void deleteById(Long id) {
        String SQL = "DELETE FROM ORDER_ENTRY WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
}