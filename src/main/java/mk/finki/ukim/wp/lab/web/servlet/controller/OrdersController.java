package mk.finki.ukim.wp.lab.web.servlet.controller;

import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.model.ShoppingCart;
import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.service.OrderService;
import mk.finki.ukim.wp.lab.service.ShoppingCartService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")

public class OrdersController {
    private final OrderService orderService;

    private final ShoppingCartService shoppingCartService;

    public OrdersController(OrderService orderService, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String getOrders(Model model, HttpServletRequest req){
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("ordersList", orders);
        model.addAttribute("clientName", req.getRemoteUser());
        return "userOrders";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getEditOrderPage(@PathVariable Long id, Model model){
        if(orderService.findById(id).isPresent()){
            Order o = orderService.findById(id).get();
            model.addAttribute("order", o);
            return "edit-order";
        }
        return "redirect:/orders";
    }

    @PostMapping
    public String saveOrder(@RequestParam String balloonColor,@RequestParam String balloonSize, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateCreated){
        orderService.placeOrder(balloonColor, balloonSize, dateCreated);
        return "redirect:/orders";
    }

    @GetMapping("/cart/{id}")
    public String shippingCard(@PathVariable Long id, Model model, HttpServletRequest req, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        ShoppingCart c = shoppingCartService.findByUser(user);
        shoppingCartService.addProductToShoppingCart(user,  id);
        model.addAttribute("cart", c);
        model.addAttribute("clientName", req.getRemoteUser());

        return "cart";
    }

    @GetMapping("/cart")
    public String getCart(Model model, HttpServletRequest req, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        ShoppingCart c = shoppingCartService.findByUser(user);
        model.addAttribute("cart", c);
        model.addAttribute("clientName", user.getName());

        return "cart";
    }
}
