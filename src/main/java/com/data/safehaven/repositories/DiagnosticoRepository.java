package com.data.safehaven.repositories;

import com.data.safehaven.entities.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {

    List<Diagnostico> findDiagnosticoByPacienteId(Long idPaciente);
    List<Diagnostico> findDiagnosticoByPsicologoId(Long idPsicologo);

}
