package edu.MosBurgers.repo;

import edu.MosBurgers.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderId(Integer orderId);

    List<OrderItem> findByFoodItemId(Integer foodItemId);
}
