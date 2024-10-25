package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String password;
    private Integer edad;
    private Integer telefono;

    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @OneToOne(mappedBy = "idUsuario")
    private Administrador administrador;

    @OneToOne(mappedBy = "idUsuario")
    private Paciente paciente;

    @OneToOne(mappedBy = "idUsuario")
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;
}