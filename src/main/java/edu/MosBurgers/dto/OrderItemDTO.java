package edu.MosBurgers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private Long id;
    private Long orderId;
    private Long foodItemId;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
}
