package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String correoElectronico;
    private Integer añosDeExperiencia;
    private String horarioDeAtencion;

    @ManyToOne
    @JoinColumn(name = "idClinica")
    private Clinica clinica;

}
