package com.restaurantmanager.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private OrderStatus status;
    private final Date createdAt;


    public Order() {
        items = new ArrayList<>();
        status = OrderStatus.PENDING;
        createdAt = new Date();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItemToOrder(OrderItem orderItem){
        items.add(orderItem);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getMenuItem().getPrice() * item.getQuantity();
        }
        return total;
    }
}
