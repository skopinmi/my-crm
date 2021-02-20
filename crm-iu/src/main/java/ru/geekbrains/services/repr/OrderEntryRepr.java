package ru.geekbrains.services.repr;

import lombok.Data;
import ru.geekbrains.models.Order;
import ru.geekbrains.models.OrderEntry;
import ru.geekbrains.models.Service;
import java.math.BigDecimal;

@Data
public class OrderEntryRepr {

    private Long id;

    private int quantity;

    private BigDecimal basePrice;

    private BigDecimal totalPrice;

    private Service service;

    private Order order;

    public OrderEntryRepr(OrderEntry orderEntry) {
        this.id = orderEntry.getId();
        this.basePrice = orderEntry.getBasePrice();
        this.service = orderEntry.getService();
        this.quantity = orderEntry.getQuantity();
        setTotalPrice();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.setTotalPrice();
    }

    private void setTotalPrice() {
        this.totalPrice = basePrice.multiply(new BigDecimal(this.quantity));
    }
}
