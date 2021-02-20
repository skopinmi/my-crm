package ru.geekbrains.services.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.repositories.OrderEntryRepository;
import ru.geekbrains.services.dbservice.repr.OrderEntryRepr;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderEntryServiceImpl implements OrderEntryService {

    private final OrderEntryRepository orderEntryRepository;

    @Autowired
    public OrderEntryServiceImpl(OrderEntryRepository orderEntryRepository) {
        this.orderEntryRepository = orderEntryRepository;
    }

    public List<OrderEntryRepr> findAll () {
        return orderEntryRepository.findAll().stream()
                .map(OrderEntryRepr :: new)
                .collect(Collectors.toList());
    }

    public OrderEntryRepr findById (Long id) {

        return new OrderEntryRepr(orderEntryRepository.findById(id).get());
    }

    @Override
    public void remove (Long id) {
        orderEntryRepository.deleteById(id);
    }

    @Override
    public void save(OrderEntryRepr orderEntryRepr) {
    }
}
