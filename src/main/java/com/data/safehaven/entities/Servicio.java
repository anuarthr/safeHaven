package com.data.safehaven.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

}
