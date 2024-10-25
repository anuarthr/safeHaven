package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Psicologo psicologo;

    @OneToMany(mappedBy = "diagnostico")
    private List<Tratamiento> tratamientos;

}
