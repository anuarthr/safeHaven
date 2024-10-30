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
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
    private List<EstadoFactura> estadoFactura;
}
