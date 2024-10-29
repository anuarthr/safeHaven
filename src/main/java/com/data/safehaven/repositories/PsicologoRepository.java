package com.data.safehaven.repositories;

import com.data.safehaven.entities.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
    Optional<Psicologo> findByNombre(String nombre);
}
