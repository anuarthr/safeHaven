package com.data.safehaven.services;


import com.data.safehaven.dtos.PacienteDto;
import com.data.safehaven.dtos.PacienteMapper;
import com.data.safehaven.entities.Paciente;
import com.data.safehaven.repositories.PacienteRepository;
import com.data.safehaven.repositories.RolRepository;
import com.ejemplo.excepciones.EmailException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    private final RolRepository rolRepository;
    private final RolService rolService;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper, RolRepository rolRepository, RolService rolService) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
        this.rolRepository = rolRepository;
        this.rolService = rolService;
    }

    @Override
    public List<PacienteDto> findAll() {
        return pacienteRepository.findAll().stream().map(pacienteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PacienteDto> findById(long id) {
        return pacienteRepository.findById(id).map(pacienteMapper::toDTO);
    }

    public Optional<Paciente> findPacienteById(long id) {
        return pacienteRepository.findById(id);
    }
    @Override
    public Optional<PacienteDto> findByNombre(String nombre) {
        return pacienteRepository.findByNombre(nombre).map(pacienteMapper::toDTO);
    }

    @Override
    public PacienteDto savePaciente(PacienteDto paciente) {
        Optional<Paciente> pacienteValidateEmail = pacienteRepository.findByCorreoElectronico(paciente.correoElectronico());
        if (pacienteValidateEmail.isPresent()) {
            throw new EmailException(paciente.correoElectronico());
        }
        Paciente pacienteEntity = pacienteMapper.toEntity(paciente, rolService);
        pacienteEntity.setFechaDeRegistro(new Date());
        return pacienteMapper.toDTO(pacienteRepository.save(pacienteEntity));
    }

    @Override
    public Optional<PacienteDto> findByCorreoElectronico(String correoElectronico) {
        return pacienteRepository.findByCorreoElectronico(correoElectronico)
                .map(pacienteMapper::toDTO);
    }

    public boolean validatePassword(PacienteDto paciente, String password) {
        return paciente.password().equals(password);
    }

    @Override
    public void deletePaciente(long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Optional<PacienteDto> updatePaciente(long id, PacienteDto paciente) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id proporcionado no es válido");
        }
        return pacienteRepository.findById(id).map(oldPaciente -> {
            oldPaciente.setNombre(paciente.nombre());
            oldPaciente.setApellido(paciente.apellido());
            oldPaciente.setCorreoElectronico(paciente.correoElectronico());
            oldPaciente.setPassword(paciente.password());
            oldPaciente.setEdad(paciente.edad());
            oldPaciente.setTelefono(paciente.telefono());
            oldPaciente.setSexo(paciente.sexo());
            oldPaciente.setFechaDeNacimiento(paciente.fechaDeNacimiento());
            oldPaciente.setAseguradora(paciente.aseguradora());
            oldPaciente.setEstadoDeSalud(paciente.estadoDeSalud());
            return pacienteRepository.save(oldPaciente);
        }).map(pacienteMapper::toDTO);
    }
}