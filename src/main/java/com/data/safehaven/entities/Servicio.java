package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private double precio;

    @OneToMany(mappedBy = "idServicio")
    private List<ServicioCita> servicioCitas;
}