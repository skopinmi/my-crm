package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Order;
import ru.geekbrains.models.OrderEntry;
import ru.geekbrains.repositories.OrderEntryRepository;
import ru.geekbrains.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderEntryService {

    private final OrderEntryRepository orderEntryRepository;

    @Autowired
    public OrderEntryService(OrderEntryRepository orderEntryRepository) {
        this.orderEntryRepository = orderEntryRepository;
    }

    public List<OrderEntry> findAll () {
        return new ArrayList<>(orderEntryRepository.findAll());
    }

    public OrderEntry findById (Long id) {
        return orderEntryRepository.findById(id).get();
    }

    public void remove (Long id) {
        orderEntryRepository.deleteById(id);
    }
}
