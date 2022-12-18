package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> placeOrder(String balloonColor, String balloonSize, LocalDateTime dateCreated);
    Optional<Order> findById(Long id);
    void deleteOrder(Long id);
    List<Order> getAllOrders();
}
