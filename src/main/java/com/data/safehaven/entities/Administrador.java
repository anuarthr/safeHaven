package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cargo;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}