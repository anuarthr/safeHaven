package com.data.safehaven.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EstadoDeFacturaId implements Serializable {

    @Column(name = "FACTURA_ID")
    private Long facturaId;

    @Column(name = "TIPODEESTADOFACTURA_ID")
    private Long tipoDeEstadoFacturaId;


}
