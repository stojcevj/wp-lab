package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.repository.jpa.OrderRepository;
import mk.finki.ukim.wp.lab.repository.standard.InMemoryOrderRepository;
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
    public Optional<Order> placeOrder(String balloonColor, String balloonSize) {
        if(balloonColor.isEmpty()){
            return Optional.empty();
        }else{
            Order o = new Order(balloonColor, balloonSize);
            orderRepository.save(o);
            return Optional.of(o);
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
