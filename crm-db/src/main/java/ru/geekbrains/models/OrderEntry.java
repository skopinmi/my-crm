package ru.geekbrains.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "order_entery")
public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_product")
    private Double basePrice;

    @Column(name = "price")
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderEntry() {
    }

    public OrderEntry(Service service) {
        this.service = service;
        this.quantity = 1;
        this.basePrice = service.getPrice();
        this.totalPrice = service.getPrice();
    }
}
