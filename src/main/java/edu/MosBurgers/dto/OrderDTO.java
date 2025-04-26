package edu.MosBurgers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderId;
    private Long customerId;
    private double totalAmount;
    private double discountPercentage;
    private double finalAmount;
    private LocalDateTime orderDate;
}
