package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Status;
import ru.geekbrains.DAO.JdbcTemplateStatusDAO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService{

//    private final StatusRepository statusRepository;

    private final JdbcTemplateStatusDAO jdbcTemplateStatusDAO;

    @Override
    public Status findById (Long id) {
        return jdbcTemplateStatusDAO.findById(id);
//        return statusRepository.findById(id).orElse(new Status());
    }

    @Override
    public void remove (Long id) {
        jdbcTemplateStatusDAO.deleteById(id);
//        statusRepository.deleteById(id);
    }

    @Override
    public void save(Status status) {
//        statusRepository.save(status);
    }

    @Override
    public List findAll() {
        return jdbcTemplateStatusDAO.findAll();
//        return statusRepository.findAll();
    }
}
