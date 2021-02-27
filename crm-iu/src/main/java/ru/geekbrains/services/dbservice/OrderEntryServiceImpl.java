package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.DAO.JdbcTemplateOrderEntryDAO;
import ru.geekbrains.models.OrderEntry;
import ru.geekbrains.repositories.OrderEntryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderEntryServiceImpl implements OrderEntryService {

//    private final OrderEntryRepository orderEntryRepository;
    private final JdbcTemplateOrderEntryDAO jdbcTemplateOrderEntryDAO;

    @Override
    public List<OrderEntry> findAll () {
        return jdbcTemplateOrderEntryDAO.findAll();
//        return orderEntryRepository.findAll();
    }

    public List<OrderEntry> findAllByOrderId(Long id) {
        return jdbcTemplateOrderEntryDAO.findAllByOrderId(id);
    }

    @Override
    public OrderEntry findById (Long id) {

        return jdbcTemplateOrderEntryDAO.findById(id);
//        return orderEntryRepository.findById(id).orElse(new OrderEntry());
    }

    @Override
    public void remove (Long id) {
        jdbcTemplateOrderEntryDAO.deleteById(id);
//        orderEntryRepository.deleteById(id);
    }

    @Override
    public void save(OrderEntry orderEntry) {
    }
}
