package edu.MosBurgers.service.impl;

import edu.MosBurgers.dto.OrderDTO;
import edu.MosBurgers.entity.Order;
import edu.MosBurgers.repo.OrderRepository;
import edu.MosBurgers.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final OrderRepository orderRepository;
    final ModelMapper modelMapper;

    @Override
    public Order addOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        BigDecimal finalAmount = calculateFinalAmount(orderDTO);
        BigDecimal finalAmount1 = new BigDecimal("finalAmount");

        order.setFinalAmount(finalAmount);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(Integer id, OrderDTO orderDTO) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setOrderId(orderDTO.getOrderId());
            //order.setCustomer(orderDTO.getCustomer());
            //order.setTotalAmount(orderDTO.getTotalAmount());
            //order.setDiscountPercentage(orderDTO.getDiscountPercentage());
            order.setFinalAmount(calculateFinalAmount(orderDTO));
            return orderRepository.save(order);
        }
          return null;
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public BigDecimal calculateFinalAmount(OrderDTO orderDTO) {
        Double totalAmount = orderDTO.getTotalAmount();
        Double discount = orderDTO.getDiscountPercentage();
        Double discountAmount = totalAmount*discount/100;
        return new BigDecimal(totalAmount-discountAmount);
    }
}
