package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
