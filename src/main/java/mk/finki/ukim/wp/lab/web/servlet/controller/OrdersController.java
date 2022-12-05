package mk.finki.ukim.wp.lab.web.servlet.controller;

import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")

public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model){
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("ordersList", orders);
        return "userOrders";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String getEditOrderPage(@PathVariable Long id, Model model){
        if(orderService.findById(id).isPresent()){
            Order o = orderService.findById(id).get();
            model.addAttribute("order", o);
            return "edit-order";
        }
        return "redirect:/orders";
    }

    @PostMapping
    public String saveOrder(@RequestParam String balloonColor,@RequestParam String balloonSize,
                            @RequestParam String clientName, @RequestParam String clientAddress,
                            @RequestParam(required = false) Long id){
        orderService.placeOrder(balloonColor, balloonSize, clientName, clientAddress, id);
        return "redirect:/orders";
    }
}
