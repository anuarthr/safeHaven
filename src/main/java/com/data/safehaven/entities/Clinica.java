package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.util.List;

@Data
@Entity
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Time horarioDeAtencion;
    private Boolean activo;

    @OneToMany(mappedBy = "clinica")
    private List<Psicologo> psicologos;

    @OneToMany(mappedBy = "clinica")
    private List<Consultorio> consultorios;

    @OneToMany(mappedBy = "clinica")
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "clinica")
    private List<Cita> citas;

    @OneToMany(mappedBy = "clinica")
    private List<Administrador> administradores;

}
