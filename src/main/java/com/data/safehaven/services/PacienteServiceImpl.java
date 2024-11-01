package com.data.safehaven.services;


import com.data.safehaven.dtos.PacienteDto;
import com.data.safehaven.dtos.PacienteMapper;
import com.data.safehaven.entities.Paciente;
import com.data.safehaven.entities.Rol;
import com.data.safehaven.entities.Usuario;
import com.data.safehaven.repositories.PacienteRepository;
import com.data.safehaven.repositories.RolRepository;
import com.data.safehaven.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

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
        return pacienteRepository.findAll().stream().map(p -> pacienteMapper.toDTO(p)).collect(Collectors.toList());
    }

    @Override
    public Optional<PacienteDto> findById(long id) {
        return pacienteRepository.findById(id).map(pacienteMapper::toDTO);
    }

    @Override
    public Optional<PacienteDto> findByNombre(String nombre) {
        return pacienteRepository.findByNombre(nombre).map(pacienteMapper::toDTO);
    }

    @Override
    public PacienteDto savePaciente(PacienteDto paciente) {
        Paciente pacienteEntity = pacienteMapper.toEntity(paciente, rolService);
        Rol rol = rolRepository.findById(paciente.rol()).orElse(null);
        pacienteEntity.setRol(rol);
        PacienteDto pacienteDTO = pacienteMapper.toDTO(pacienteRepository.save(pacienteEntity));
        return pacienteDTO;
    }


    @Override
    public void deletePaciente(long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Optional<PacienteDto> updatePaciente(long id, PacienteDto paciente) {
        return pacienteRepository.findById(id).map(oldPaciente -> {
            oldPaciente.setNombre(paciente.nombre());
            oldPaciente.setApellido(paciente.apellido());
            oldPaciente.setRol(rolRepository.findById(paciente.rol()).orElse(null));
            oldPaciente.setCorreoElectronico(paciente.correoElectronico());
            oldPaciente.setPassword(paciente.password());
            oldPaciente.setEdad(paciente.edad());
            oldPaciente.setTelefono(paciente.telefono());
            oldPaciente.setSexo(paciente.sexo());
            oldPaciente.setFechaDeNacimiento(paciente.fechaDeNacimiento());
            oldPaciente.setFechaDeRegistro(paciente.fechaDeRegistro());
            oldPaciente.setAseguradora(oldPaciente.getAseguradora());
            oldPaciente.setEstadoDeSalud(paciente.estadoDeSalud());
            return pacienteRepository.save(oldPaciente);
        }).map(pacienteMapper::toDTO);
    }
}