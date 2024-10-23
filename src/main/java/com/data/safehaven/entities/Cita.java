package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.TIME)
    private Date hora;
    private String estado;
    private String motivo;
    private Integer duracion;
    private String tipoCita;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "idConsultorio")
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn(name = "idClinica")
    private Clinica clinica;

}

