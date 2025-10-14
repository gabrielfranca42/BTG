package dto;

import model.OderItemModel;

import java.util.List;

public record OderCreatedEventDto(Long codigoPedido,
                                  Long codigoCliente,
                                  List<OderItemEventDto> items) {
}
