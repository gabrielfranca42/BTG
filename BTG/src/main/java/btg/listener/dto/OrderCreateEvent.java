package btg.listener.dto;

import java.util.List;

public record OrderCreateEvent(Long codigoPedido,
                               Long codigoCliente,
                               List<OrderItemEvent> itens) {
}
