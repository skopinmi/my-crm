package ru.geekbrains.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.geekbrains.models.Order;
import ru.geekbrains.models.OrderEntry;
import ru.geekbrains.models.Service;
import ru.geekbrains.models.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper implements RowMapper {


    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

        List<OrderEntry> orderEntries = new ArrayList<>();
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