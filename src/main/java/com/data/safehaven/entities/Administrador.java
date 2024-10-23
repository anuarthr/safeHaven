package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String cargo;

    @ManyToOne
    @JoinColumn(name = "idClinica")
    private Clinica clinica;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

}


