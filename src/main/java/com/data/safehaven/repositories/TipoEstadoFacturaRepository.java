package com.data.safehaven.repositories;

import com.data.safehaven.entities.TipoEstadoFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoEstadoFacturaRepository extends JpaRepository<TipoEstadoFactura, Long> {

    Optional<TipoEstadoFactura> findByNombre(String nombre);
}
