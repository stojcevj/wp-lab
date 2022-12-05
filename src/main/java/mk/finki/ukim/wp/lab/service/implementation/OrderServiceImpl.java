package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.repository.OrderRepository;
import mk.finki.ukim.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> placeOrder(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderId) {
        if(balloonColor.isEmpty() || clientName.isEmpty() || balloonSize.isEmpty() || clientAddress.isEmpty()){
            return Optional.empty();
        }else{
            Order o = new Order(balloonColor, balloonSize, clientName, clientAddress, orderId);
            orderRepository.deleteOrder(orderId);
            orderRepository.addOrder(o);
            return Optional.of(o);
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteOrder(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return DataHolder.orders.stream().toList();
    }
}
