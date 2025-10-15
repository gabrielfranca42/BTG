package model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderItemModel {

    private String product;
    private Integer quantity;
    private BigDecimal price;

}
