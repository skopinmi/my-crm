package ru.geekbrains.services.dbservice;

import ru.geekbrains.services.dbservice.repr.OrderEntryRepr;
import ru.geekbrains.services.dbservice.repr.UserRepr;

import java.util.List;

public interface OrderEntryService {

    void save(OrderEntryRepr orderEntryRepr);

    List<OrderEntryRepr> findAll();

    OrderEntryRepr findById(Long id);

    void remove(Long id);
}
