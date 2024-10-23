package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.util.List;

@Data
@Entity
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private Integer capacidad;
    private Time horarioDeApertura;
    private Time horarioDeCierre;
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "idClinica")
    private Clinica clinica;

    @OneToMany(mappedBy = "consultorio")
    private List<Cita> citas;

}
