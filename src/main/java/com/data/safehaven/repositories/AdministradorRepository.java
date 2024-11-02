package com.data.safehaven.repositories;

import com.data.safehaven.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByNombre(String nombre);
}
