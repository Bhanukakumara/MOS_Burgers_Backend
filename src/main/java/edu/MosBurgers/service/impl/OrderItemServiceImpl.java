package edu.MosBurgers.service.impl;

import edu.MosBurgers.dto.OrderItemDTO;
import edu.MosBurgers.entity.OrderItem;
import edu.MosBurgers.repo.OrderItemRepository;
import edu.MosBurgers.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    final OrderItemRepository orderItemRepository;
    final ModelMapper modelMapper;

    @Override
    public OrderItem addOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = modelMapper.map(orderItemDTO, OrderItem.class);
        BigDecimal totalPrice = orderItem.getUnitPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()));
        orderItem.setTotalPrice(totalPrice);
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById(Integer id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem updateOrderItem(Integer id, OrderItemDTO orderItemDTO) {
        Optional<OrderItem> existingOrderItemOptional = orderItemRepository.findById(id);
        if (existingOrderItemOptional.isPresent()) {
            OrderItem existingOrderItem = existingOrderItemOptional.get();
            existingOrderItem.setQuantity(orderItemDTO.getQuantity());
            //existingOrderItem.setUnitPrice(orderItemDTO.getUnitPrice());
            BigDecimal totalPrice = existingOrderItem.getUnitPrice().multiply(BigDecimal.valueOf(existingOrderItem.getQuantity()));
            existingOrderItem.setTotalPrice(totalPrice);
            return orderItemRepository.save(existingOrderItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Integer orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public List<OrderItem> getOrderItemsByFoodItemId(Integer foodItemId) {
        return orderItemRepository.findByFoodItemId(foodItemId);
    }
}
