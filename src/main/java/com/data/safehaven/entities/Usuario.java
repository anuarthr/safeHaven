package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToOne(mappedBy = "usuario")
    private Administrador administrador;

    @OneToOne(mappedBy = "usuario")
    private Paciente paciente;

}
