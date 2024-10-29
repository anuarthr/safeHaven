package com.data.safehaven.repositories;

import com.data.safehaven.entities.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    Optional<Tratamiento> findByNombre(String nombre);
}
