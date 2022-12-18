package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.model.ShoppingCart;
import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.repository.jpa.OrderRepository;
import mk.finki.ukim.wp.lab.repository.jpa.ShoppingCartRepository;
import mk.finki.ukim.wp.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderRepository orderRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, OrderRepository orderRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCart findByUser(User user) {
        return shoppingCartRepository.findByUser(user).orElseGet(() -> {
            ShoppingCart cart = new ShoppingCart(user);
            return this.shoppingCartRepository.save(cart);
        });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(User user, Long id) {
        Optional<ShoppingCart> cart = shoppingCartRepository.findByUser(user);
        cart.get().getOrders().add(orderRepository.findById(id).get());
        return shoppingCartRepository.save(cart.get());
    }
}
