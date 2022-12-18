package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.ShoppingCart;
import mk.finki.ukim.wp.lab.model.User;

import java.util.Optional;

public interface ShoppingCartService {
    Optional<ShoppingCart> findById(Long id);
    ShoppingCart findByUser(User user);
    ShoppingCart addProductToShoppingCart(User user, Long id);
}
