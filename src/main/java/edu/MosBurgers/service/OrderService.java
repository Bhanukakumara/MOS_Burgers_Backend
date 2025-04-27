package edu.MosBurgers.service;

import edu.MosBurgers.dto.OrderDTO;
import edu.MosBurgers.entity.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order addOrder(OrderDTO orderDTO);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Integer id);
    Order updateOrder(Integer id, OrderDTO orderDTO);
    void deleteOrder(Integer id);
    List<Order> getOrdersByCustomerId(Integer customerId);
    BigDecimal calculateFinalAmount(OrderDTO orderDTO);
}
