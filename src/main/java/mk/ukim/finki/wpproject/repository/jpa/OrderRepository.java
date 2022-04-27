package mk.ukim.finki.wpproject.repository.jpa;

import mk.ukim.finki.wpproject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
