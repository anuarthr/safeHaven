package com.data.safehaven.services;

import com.data.safehaven.entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    List<Paciente> findAll();

    Optional<Paciente> findById(long id);

    Optional<Paciente> findByNombre(String nombre);

    Paciente savePaciente(Paciente paciente);

    void deletePaciente(long id);

    Optional<Paciente> updatePaciente(long id, Paciente paciente);
}
