package ru.geekbrains.services.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Order;
import ru.geekbrains.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll () {
        return new ArrayList<>(orderRepository.findAll());
    }

    public Order findById (Long id) {
        return orderRepository.findById(id).get();
    }

    public void remove (Long id) {
        orderRepository.deleteById(id);
    }
}
