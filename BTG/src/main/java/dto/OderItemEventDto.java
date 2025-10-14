package dto;

import java.util.List;

public record OderItemEventDto(Long codigoPedido,
                               Long codigoCliente,
                               List<OderCreatedEventDto> items) {
}
