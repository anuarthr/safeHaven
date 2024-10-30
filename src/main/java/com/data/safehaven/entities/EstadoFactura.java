package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estadosFactura")
public class EstadoFactura {


    @EmbeddedId
    private EstadoDeFacturaId id;

    @ManyToOne
    @MapsId("facturaId")
    @JoinColumn(name = "FACTURA_ID")
    private Factura factura;

    @ManyToOne
    @MapsId("tipoDeEstadoFacturaId")
    @JoinColumn(name = "TIPODEESTADOFACTURA_ID")
    private TipoEstadoFactura tipoEstadoFactura;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaFinEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioDeRegistroEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaFinDeRegistroEstado;


}
