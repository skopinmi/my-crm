package ru.geekbrains.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_entry")
public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_product")
    private BigDecimal basePrice;

    @Column(name = "price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderEntry() {
    }

    public OrderEntry(Service service, Integer quantity) {
        this.service = service;
        this.quantity = quantity;
        this.basePrice = service.getPrice();
    }
}
