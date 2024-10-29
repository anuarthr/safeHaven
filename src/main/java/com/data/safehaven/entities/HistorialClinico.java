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
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;

    private String comentarios;

    @OneToMany(mappedBy = "idHistorialClinico", fetch = FetchType.LAZY)
    private List<Tratamiento> tratamiento;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
}
