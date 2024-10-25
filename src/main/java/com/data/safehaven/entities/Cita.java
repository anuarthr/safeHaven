package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String motivo;
    private Integer duracion;
    private String tipoCita;
    private String insertBy;
    private String updateBy;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.TIME)
    private Date hora;

    @Temporal(TemporalType.DATE)
    private Date insertAt;

    @Temporal(TemporalType.DATE)
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "idConsultorio")
    private Consultorio consultorio;

    @OneToMany(mappedBy = "idCita")
    List<Factura> factura;

    @OneToMany(mappedBy = "idCita")
    List<ServicioCita> servicioDeCita;

    @OneToMany(mappedBy = "idCita")
    List<EstadoCita> estadoCita;
}

