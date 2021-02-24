package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Order;
import ru.geekbrains.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final OrderRepository orderRepository;

    public List<Order> findAll () {
        return new ArrayList<>(orderRepository.findAll());
    }

    public Order findById (Long id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    public void remove (Long id) {
        orderRepository.deleteById(id);
    }
}
