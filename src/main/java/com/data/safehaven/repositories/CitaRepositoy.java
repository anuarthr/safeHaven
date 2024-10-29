package com.data.safehaven.repositories;

import com.data.safehaven.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CitaRepositoy extends JpaRepository<Cita, Long> {
    List<Cita> findByPacienteId(Long id);
    List<Cita> findByPsicologoId(Long id);
    List<Cita> findByConsultorioId(Long id);
}
