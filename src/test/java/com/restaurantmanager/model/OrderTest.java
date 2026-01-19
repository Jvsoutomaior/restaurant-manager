package com.restaurantmanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OrderTest{
    private Order order;
    private MenuItem pizza;

    @BeforeEach
    void setup(){
        order = new Order();
        pizza = new MenuItem("pizza", (float) 89.90, "calabresa", MenuItemType.MAIN);
    }

    @Test
    void newOrder_ShouldStartWithPendingStatus(){
        assertEquals(OrderStatus.PENDING, order.getStatus());
    }

    @Test
    void newOrder_shouldStartWithNoItems(){
        assertTrue(order.getItems().isEmpty());
    }

    @Test
    void addItem_shouldAddItemToOrder() {
        OrderItem item = new OrderItem(pizza, 2);

        order.addItemToOrder(item);

        assertEquals(1, order.getItems().size());
        assertEquals(2, order.getItems().get(0).getQuantity());
    }

    @Test
    void getTotalPrice_shouldCalculateCorrectTotal() {
        order.addItemToOrder(new OrderItem(pizza, 2));
        order.addItemToOrder(new OrderItem(pizza, 1));

        assertEquals(pizza.getPrice() * 3, order.getTotalPrice());
    }
}