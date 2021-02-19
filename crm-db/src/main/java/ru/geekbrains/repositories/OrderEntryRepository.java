package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.models.OrderEntry;

public interface OrderEntryRepository extends JpaRepository<OrderEntry, Long> {
}
