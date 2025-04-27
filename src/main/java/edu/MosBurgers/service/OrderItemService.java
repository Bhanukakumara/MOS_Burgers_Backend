package edu.MosBurgers.service;

import edu.MosBurgers.dto.OrderItemDTO;
import edu.MosBurgers.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    OrderItem addOrderItem(OrderItemDTO orderItemDTO);
    List<OrderItem> getAllOrderItems();
    Optional<OrderItem> getOrderItemById(Integer id);
    OrderItem updateOrderItem(Integer id, OrderItemDTO orderItemDTO);
    void deleteOrderItem(Integer id);
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    List<OrderItem> getOrderItemsByFoodItemId(Integer foodItemId);
}
