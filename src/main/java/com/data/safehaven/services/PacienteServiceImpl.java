package com.data.safehaven.services;

import com.data.safehaven.entities.Paciente;
import com.data.safehaven.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Optional<Paciente> findByNombre(String nombre) {
        return pacienteRepository.findByNombre(nombre);
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        Paciente pacienteSaved = pacienteRepository.save(paciente);
        return pacienteSaved;
    }

    @Override
    public void deletePaciente(long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Optional<Paciente> updatePaciente(long id, Paciente paciente) {
        return pacienteRepository.findById(id).map(oldPaciente -> {
            oldPaciente.setNombre(paciente.getNombre());
            oldPaciente.setApellido(paciente.getApellido());
            oldPaciente.setRol(paciente.getRol());
            oldPaciente.setCorreoElectronico(paciente.getCorreoElectronico());
            oldPaciente.setPassword(paciente.getPassword());
            oldPaciente.setEdad(paciente.getEdad());
            oldPaciente.setTelefono(paciente.getTelefono());
            oldPaciente.setSexo(paciente.getSexo());
            oldPaciente.setFechaDeNacimiento(paciente.getFechaDeNacimiento());
            oldPaciente.setFechaDeRegistro(paciente.getFechaDeRegistro());
            oldPaciente.setAseguradora(oldPaciente.getAseguradora());
            oldPaciente.setEstadoDeSalud(paciente.getEstadoDeSalud());
            return pacienteRepository.save(oldPaciente);
        });
    }
}