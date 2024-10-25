package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ServicioCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicioCita;

    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "idCita")
    private Cita cita;
}
