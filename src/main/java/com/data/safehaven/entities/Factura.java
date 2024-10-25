package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double monto;
    private String insertBy;
    private String updateBy;

    @Temporal(TemporalType.DATE)
    private Date fechaDePago;

    @Temporal(TemporalType.DATE)
    private Date insertAt;

    @Temporal(TemporalType.DATE)
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "idCita")
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @OneToMany(mappedBy = "idFactura")
    private List<EstadoFactura> estadoFactura;
}
