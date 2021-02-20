package ru.geekbrains.services.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Status;
import ru.geekbrains.repositories.StatusRepository;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService{

    StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status findById (Long id) {
        return statusRepository.findById(id).get();
    }

    public void remove (Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
