package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;

    private String comentarios;

    @OneToMany(mappedBy = "idHistorialClinico")
    private List<Tratamiento> tratamiento;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
}
