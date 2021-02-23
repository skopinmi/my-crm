package ru.geekbrains.services.dbservice;

import ru.geekbrains.models.OrderEntry;

import java.util.List;

public interface OrderEntryService {

    void save(OrderEntry orderEntry);

    List<OrderEntry> findAll();

    OrderEntry findById(Long id);

    void remove(Long id);
}
