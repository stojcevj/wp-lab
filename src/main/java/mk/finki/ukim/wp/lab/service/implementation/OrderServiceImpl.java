package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.repository.OrderRepository;
import mk.finki.ukim.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void placeOrder(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderId) {
        if(balloonColor.isEmpty() || clientName.isEmpty() || balloonSize.isEmpty() || clientAddress.isEmpty()){

        }else{
            orderRepository.addOrder(new Order(balloonColor, balloonSize, clientName, clientAddress, orderId));
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return DataHolder.orders.stream().toList();
    }
}
