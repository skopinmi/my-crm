package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Status;
import ru.geekbrains.repositories.StatusRepository;

import java.util.List;

@Service
public class StatusService {

    StatusRepository statusRepository;

    @Autowired
    public StatusService (StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status findById (Long id) {
        return statusRepository.findById(id).get();
    }
}
