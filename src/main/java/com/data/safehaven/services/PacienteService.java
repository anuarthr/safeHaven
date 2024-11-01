package com.data.safehaven.services;


import com.data.safehaven.dtos.PacienteDto;
import com.data.safehaven.entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    List<PacienteDto> findAll();

    Optional<PacienteDto> findById(long id);

    Optional<PacienteDto> findByNombre(String nombre);

    PacienteDto savePaciente(PacienteDto paciente);

    void deletePaciente(long id);

    Optional<PacienteDto> updatePaciente(long id, PacienteDto paciente);
}
