package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Order;
import ru.geekbrains.repositories.OrderRepository;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
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
