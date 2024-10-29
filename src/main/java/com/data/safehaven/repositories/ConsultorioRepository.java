package com.data.safehaven.repositories;

import com.data.safehaven.entities.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
    Optional<Consultorio> findByNombre(String nombre);
    List<Consultorio> findByActivoTrue();
}
