package edu.MosBurgers.repo;

import edu.MosBurgers.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrdersByCustomerId(Integer customerId);
}
