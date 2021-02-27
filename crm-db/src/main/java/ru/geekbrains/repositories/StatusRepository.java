package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.models.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
