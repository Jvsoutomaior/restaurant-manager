package com.restaurantmanager.controller;
import java.util.ArrayList;
import java.util.List;

import com.restaurantmanager.model.Order;
import com.restaurantmanager.model.OrderItem;

public class OrderController {
    private List<Order> orders;

    public OrderController() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order createNewOrder() {
        Order newOrder = new Order();
        orders.add(newOrder);
        return newOrder;
    }

    public void addItemToOrder(Order order, OrderItem item) {
        order.getItems().add(item);
    }

    public void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        System.out.println("\n##### ORDERS #####");
        for (Order order : orders) {
            System.out.println(String.format("Order - Status: %s - Created: %s",
                order.getStatus(),
                order.getCreatedAt()));
            
            System.out.println("Items:");
            for (OrderItem item : order.getItems()) {
                System.out.println(String.format("  - %dx %s @ %.2f = %.2f",
                    item.getQuantity(),
                    item.getMenuItem().getName(),
                    item.getMenuItem().getPrice(),
                    item.getQuantity() * item.getMenuItem().getPrice()));
            }
            
            System.out.println(String.format("Total: %.2f", order.getTotalPrice()));
            System.out.println("------------------");
        }
        System.out.println("##################\n");
    }


}
