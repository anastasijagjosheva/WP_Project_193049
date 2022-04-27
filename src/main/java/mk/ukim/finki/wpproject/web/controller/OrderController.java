package mk.ukim.finki.wpproject.web.controller;


import mk.ukim.finki.wpproject.model.Order;
import mk.ukim.finki.wpproject.model.Product;
import mk.ukim.finki.wpproject.service.OrderService;
import mk.ukim.finki.wpproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }

    @GetMapping
    public String getOrdersPage(@RequestParam(required = false) String error, Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Order> orders = this.orderService.findAll();
        model.addAttribute("orders", orders);

        return "orders";
    }

    @GetMapping("/add-form")
    public String makeOrderPage(@RequestParam String productName, Model model) {
        model.addAttribute("productName", productName);
        return "make-order";
    }

    @GetMapping("/edit-form")
    public String editOrderPage(@RequestParam Long orderId, Model model) {

        if (this.orderService.findById(orderId).isPresent()) {
            Order order = this.orderService.findById(orderId).get();
            model.addAttribute("order", order);
            model.addAttribute("productName",  order.getProductName());
            return "make-order";
        }

        return "redirect:/orders?error=OrderNotFound";
    }

    @PostMapping("/add")
    public String saveOrder(@RequestParam(required = false) Long orderId,
                            @RequestParam String productName,
                            @RequestParam Integer quantity,
                            @RequestParam String address,
                            @RequestParam String customerMail,
                            @RequestParam String customerName,
                            @RequestParam String customerSurname) {

        if (orderId != null) {
            this.orderService.edit(orderId, productName, quantity, address, customerMail, customerName, customerSurname);
        } else {
            this.orderService.save(productName, quantity, address, customerMail, customerName, customerSurname);
        }

        return "redirect:/orders";
    }
}

