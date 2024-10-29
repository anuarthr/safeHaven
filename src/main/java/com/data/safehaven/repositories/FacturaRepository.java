package com.data.safehaven.repositories;

import com.data.safehaven.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    Optional<Factura> findByIdCita(Long idCita);
    Optional<Factura> findByIdPaciente(Long idPaciente);
}
