package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String condicionEspecial;

    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @ManyToOne
    @JoinColumn(name = "idHistorialClinico")
    private HistorialClinico historialClinico;

    @ManyToOne
    @JoinColumn(name = "idClinica")
    private Clinica clinica;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

}
