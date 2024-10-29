package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private Integer capacidad;
    private LocalTime horarioDeApertura;
    private LocalTime horarioDeCierre;
    private Boolean activo;

    @OneToMany(mappedBy = "consultorio", fetch = FetchType.LAZY)
    private List<Cita> citas;
}
