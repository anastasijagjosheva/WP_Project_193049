package mk.ukim.finki.wpproject.service;

import mk.ukim.finki.wpproject.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    List<Product> findAllByCategory(Long categoryId);

    Optional<Product> save(String name, Double price, Integer quantity,
                           Long categoryId, String imageProduct, String description);

    Optional<Product> edit(Long id, String name, Double price, Integer quantity,
                           Long categoryId, String imageProduct, String description);

    void deleteId(Long id);
}
