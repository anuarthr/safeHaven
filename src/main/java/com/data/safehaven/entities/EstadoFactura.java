package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class EstadoFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoFactura;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaFinEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioDeRegistroEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaFinDeRegistroEstado;

    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "idTipoEstadoFactura")
    private TipoEstadoFactura tipoEstadoFactura;
}
