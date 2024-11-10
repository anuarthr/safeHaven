package com.data.safehaven.repositories;

import com.data.safehaven.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNombre(String nombre);
    Optional<Paciente> findByCorreoElectronico(String correoElectronico);
}
