package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.Order;
import ru.geekbrains.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper implements RowMapper <Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setTotalPrice(rs.getBigDecimal("total_price"));
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setName(rs.getString("u.name"));
        user.setEmail(rs.getString("u.email"));
        user.setPhone(rs.getString("u.phone"));
        user.setDescription(rs.getString("u.description"));
        order.setUser(user);
        return order;
    }
}