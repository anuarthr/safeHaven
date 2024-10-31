package com.data.safehaven.dtos;

import com.data.safehaven.entities.EstadoDeFacturaId;
import com.data.safehaven.entities.Factura;
import com.data.safehaven.entities.TipoEstadoFactura;

import java.util.Date;

public record EstadoFacturaDto(EstadoDeFacturaId id,
                               Factura factura,
                               TipoEstadoFactura tipoEstadoFactura,
                               Date fechaInicioEstado,
                               Date fechaFinEstado,
                               Date fechaInicioDeRegistroEstado,
                               Date fechaFinDeRegistroEstado) {
}
