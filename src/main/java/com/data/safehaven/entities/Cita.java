package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivo;

    private LocalTime duracion;

    private String tipoCita;

    private String insertBy;
    private String updateBy;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.TIME)
    private LocalTime hora;

    @Temporal(TemporalType.DATE)
    private Date insertAt;

    @Temporal(TemporalType.DATE)
    private Date updateAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "pacienteId")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(nullable = false, name = "psicologoId")
    private Psicologo psicologo;
    @ManyToOne
    @JoinColumn(nullable = false, name = "consultorioId")
    private Consultorio consultorio;

    @OneToMany(mappedBy = "cita", fetch = FetchType.LAZY)
    private List<Factura> factura;

    @OneToMany(mappedBy = "cita", fetch = FetchType.LAZY)
    private List<ServicioCita> servicioDeCita;

    @OneToMany(mappedBy = "cita", fetch = FetchType.LAZY)
    private List<EstadoCita> estadoCita;
}

