package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String password;
    private Integer edad;
    private Long telefono;
    private String sexo;
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRol", nullable = true)
    private Rol rol;
}