package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class EstadoCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoCita;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaFinEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioDeRegistroEstado;

    @Temporal(TemporalType.DATE)
    private Date fechaFinDeRegistroEstado;

    @ManyToOne
    @JoinColumn(name = "idCita")
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "idTipoEstadoCita")
    private TipoEstadoCita tipoEstadoCita;
}
