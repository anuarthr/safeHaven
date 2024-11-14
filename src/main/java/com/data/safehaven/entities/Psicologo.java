package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "psicologos")
public class Psicologo extends Usuario{


    private String especialidad;
    private Integer añosDeExperiencia;
    private String horarioDeAtencion;

    @OneToMany(mappedBy = "psicologo")
    private List<Tratamiento> tratamientos;

    @OneToMany(mappedBy = "psicologo")
    private List<Cita> citas;

}
