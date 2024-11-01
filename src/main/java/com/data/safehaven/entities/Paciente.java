package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Usuario{

    private String aseguradora;
    private String estadoDeSalud;

    @Temporal(TemporalType.DATE)
    private Date fechaDeRegistro;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<HistorialClinico> historialClinico;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Diagnostico> diagnostico;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Cita> cita;
}
