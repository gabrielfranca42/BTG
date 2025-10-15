package dto;

import java.util.List;


public record OrderItemEventDto(Long codigoPedido,
                                Long codigoCliente,
                                List<OrderCreatedEventDto> items) {
}
