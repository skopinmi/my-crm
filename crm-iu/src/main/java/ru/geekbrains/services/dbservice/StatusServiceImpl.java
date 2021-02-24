package ru.geekbrains.services.dbservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.Status;
import ru.geekbrains.repositories.StatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService{

    private final StatusRepository statusRepository;

    @Override
    public Status findById (Long id) {
        return statusRepository.findById(id).orElse(new Status());
    }

    @Override
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
