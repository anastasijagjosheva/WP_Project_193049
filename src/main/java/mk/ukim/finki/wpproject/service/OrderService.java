package mk.ukim.finki.wpproject.service;

import mk.ukim.finki.wpproject.model.Order;
import mk.ukim.finki.wpproject.model.Product;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(Long orderId);

    List<Order> findAll();

    Optional<Order> save(String productName, Integer quantity, String address,
                         String customerMail, String customerName,String customerSurname);

    Optional<Order> edit (Long orderId, String productName, Integer quantity,
                          String address, String customerMail, String customerName,String customerSurname);
}
