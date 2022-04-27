package mk.ukim.finki.wpproject.repository.jpa;

import mk.ukim.finki.wpproject.model.Category;
import mk.ukim.finki.wpproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    void deleteByName(String name);

    List<Product> findAllByCategory(Category category);

   // Optional<Product> findById(Long id);
}
