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
@Table(name = "estadosCita")
public class EstadoCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoCita;

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
