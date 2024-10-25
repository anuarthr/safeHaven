package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String especialidad;
    private Integer añosDeExperiencia;
    private String horarioDeAtencion;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "idPsicologo")
    private List<Tratamiento> tratamientos;

    @OneToMany(mappedBy = "idPsicologo")
    private List<Cita> citas;
}
