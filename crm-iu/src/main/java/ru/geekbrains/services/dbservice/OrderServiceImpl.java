package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.DAO.JdbcTemplateOrderDAO;
import ru.geekbrains.models.Order;
import ru.geekbrains.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

//    private final OrderRepository orderRepository;
    private final JdbcTemplateOrderDAO jdbcTemplateOrderDAO;

    public List<Order> findAll () {
        return jdbcTemplateOrderDAO.findAll();
//        return new ArrayList<>(orderRepository.findAll());
    }

    public Order findById (Long id) {
        return jdbcTemplateOrderDAO.findById(id);
//        return orderRepository.findById(id).orElse(new Order());
    }

    public void remove (Long id) {
        jdbcTemplateOrderDAO.deleteById(id);
//        orderRepository.deleteById(id);
    }
}
