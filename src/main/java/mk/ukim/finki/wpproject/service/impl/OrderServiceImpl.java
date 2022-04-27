package mk.ukim.finki.wpproject.service.impl;

import mk.ukim.finki.wpproject.model.Order;
import mk.ukim.finki.wpproject.model.Product;
import mk.ukim.finki.wpproject.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.wpproject.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpproject.repository.jpa.OrderRepository;
import mk.ukim.finki.wpproject.repository.jpa.ProductRepository;
import mk.ukim.finki.wpproject.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Optional<Order> findById(Long orderId) {
        return this.orderRepository.findById(orderId);
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Order> save(String productName, Integer quantity, String address,
                                String customerMail,String customerName,String customerSurname ) {

        Order order = new Order(productName, quantity, address, customerMail, customerName, customerSurname);
        return  Optional.of(this.orderRepository.save(order));
    }

    @Override
    @Transactional
    public Optional<Order> edit (Long orderId, String productName, Integer quantity, String address,
                                 String customerMail, String customerName,String customerSurname) {
       Order order = this.orderRepository.findById(orderId)
               .orElseThrow(() -> new OrderNotFoundException(orderId));


        order.setQuantity(quantity);
        order.setAddress(address);
        order.setCustomerMail(customerMail);
        order.setCustomerName(customerName);
        order.setCustomerSurname(customerSurname);

        return  Optional.of(this.orderRepository.save(order));
    }


}
