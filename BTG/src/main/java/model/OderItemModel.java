package model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OderItemModel {

    private String product;
    private Integer quantity;
    private BigDecimal price;

}
