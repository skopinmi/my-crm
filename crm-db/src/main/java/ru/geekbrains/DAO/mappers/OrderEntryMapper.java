package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.geekbrains.models.*;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class OrderEntryMapper implements RowMapper <OrderEntry> {

    @Override
    public OrderEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderEntry orderEntry = new OrderEntry();
        orderEntry.setId(rs.getLong("id"));
        orderEntry.setQuantity(rs.getInt("quantity"));
        orderEntry.setBasePrice(rs.getBigDecimal("price"));
        User user = new User();
        user.setId(rs.getLong("u.id"));
        user.setName(rs.getString("u.name"));
        user.setEmail(rs.getString("u.email"));
        user.setPhone(rs.getString("u.phone"));
        user.setDescription(rs.getString("u.description"));
        Order order = new Order();
        order.setId(rs.getLong("o.id"));
        order.setTotalPrice(rs.getBigDecimal("o.total_price"));
        order.setId(rs.getLong("o.id"));
        order.setUser(user);
        Service service = new Service();
        service.setId(rs.getLong("s.id"));
        service.setPrice(rs.getBigDecimal("s.price"));
        service.setDescription(rs.getString("s.description"));
        service.setName(rs.getString("s.name"));
        orderEntry.setService(service);
        return orderEntry;
    }
}