package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
