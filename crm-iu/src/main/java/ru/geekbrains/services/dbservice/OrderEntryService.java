package ru.geekbrains.services;

import ru.geekbrains.services.repr.OrderEntryRepr;
import ru.geekbrains.services.repr.UserRepr;

import java.util.List;

public interface OrderEntryService {

    void save(OrderEntryRepr orderEntryRepr);

    List<OrderEntryRepr> findAll();

    OrderEntryRepr findById(Long id);

    void remove(Long id);
}
