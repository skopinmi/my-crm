package ru.geekbrains.services.dbservice;

import ru.geekbrains.models.Status;

import java.util.List;

public interface StatusService {

    void save(Status status);

    List<Status> findAll();

    Status findById(Long id);

    void remove(Long id);
}
