package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double monto;

    @Temporal(TemporalType.DATE)
    private Date fechaDePago;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "idCita")
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "idClinica")
    private Clinica clinica;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @OneToMany
    private List<Servicio> servicios;

}
