package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Order;

import java.util.List;

public interface OrderService {
    void placeOrder(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderId);
    List<Order> getAllOrders();
}
