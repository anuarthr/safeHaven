package com.data.safehaven.repositories;

import com.data.safehaven.entities.TipoEstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoEstadoCitaRepository extends JpaRepository<TipoEstadoCita, Long> {
    Optional<TipoEstadoCita> findByNombre(String nombre);
}
