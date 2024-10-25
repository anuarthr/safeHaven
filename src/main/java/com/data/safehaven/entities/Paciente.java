package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String condicionEspecial;

    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "idPaciente")
    private List<HistorialClinico> historialClinico;

    @OneToMany(mappedBy = "idPaciente")
    private List<Diagnostico> diagnostico;

    @OneToMany(mappedBy = "idPaciente")
    private List<Cita> cita;
}
