package btg.controller.dto;

import btg.model.OrderModel;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal total) {

    public static OrderResponse fromModel(OrderModel model){
        return new OrderResponse(model.getOrderId(), model.getCustomerId(), model.getTotal());
    }
}
