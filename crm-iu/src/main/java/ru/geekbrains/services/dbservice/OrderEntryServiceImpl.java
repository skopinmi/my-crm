package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.OrderEntry;
import ru.geekbrains.repositories.OrderEntryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderEntryServiceImpl implements OrderEntryService {

    private final OrderEntryRepository orderEntryRepository;

    public List<OrderEntry> findAll () {
        return orderEntryRepository.findAll();
    }

    public OrderEntry findById (Long id) {

        return orderEntryRepository.findById(id).get();
    }

    @Override
    public void remove (Long id) {
        orderEntryRepository.deleteById(id);
    }

    @Override
    public void save(OrderEntry orderEntry) {
    }
}
