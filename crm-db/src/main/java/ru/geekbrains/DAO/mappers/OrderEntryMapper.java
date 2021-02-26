package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.geekbrains.models.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderEntryMapper implements RowMapper {

    private Long id;

    private int quantity;

    private BigDecimal basePrice;

    private BigDecimal totalPrice;

    private Service service;

    private Order order;

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
        order.setTotalPrice(rs.getBigDecimal("o.totalPrice"));
        order.setUser(user);
        Service service = new Service();
        service.setId(rs.getLong("oe.id"));
        service.setPrice(rs.getBigDecimal("oe.totalprice"));
        service.setDescription(rs.getString("oe.description"));
        service.setName(rs.getString("oe.name"));
        orderEntry.setService(service);
        return orderEntry;
    }
}