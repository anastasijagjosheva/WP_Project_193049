package mk.ukim.finki.wpproject.repository.jpa;

import mk.ukim.finki.wpproject.model.ShoppingCart;
import mk.ukim.finki.wpproject.model.User;
import mk.ukim.finki.wpproject.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}
