package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "idDiagnostico")
    private Diagnostico diagnostico;

    @ManyToOne
    @JoinColumn(name = "idHistorialClinico")
    private HistorialClinico historialClinico;

}

