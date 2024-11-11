package com.data.safehaven.services;


import com.data.safehaven.dtos.PsicologoDto;
import com.data.safehaven.dtos.PsicologoMapper;
import com.data.safehaven.entities.Psicologo;
import com.data.safehaven.repositories.PsicologoRepository;
import com.data.safehaven.repositories.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PsicologoService {

    private final PsicologoRepository psicologoRepository;
    private final PsicologoMapper psicologoMapper;
    private final RolRepository rolRepository;
    private final RolService rolService;

    public PsicologoService(PsicologoRepository psicologoRepository, PsicologoMapper psicologoMapper, RolRepository rolRepository, RolService rolService) {
        this.psicologoRepository = psicologoRepository;
        this.psicologoMapper = psicologoMapper;
        this.rolRepository = rolRepository;
        this.rolService = rolService;
    }

    public List<PsicologoDto> findAll() {
        return psicologoRepository.findAll().stream().map(p -> psicologoMapper.toDTO(p)).collect(Collectors.toList());
    }

    public Optional<PsicologoDto> findById(long id) {
        return psicologoRepository.findById(id).map(psicologoMapper::toDTO);
    }

    public Optional<Psicologo> findPsicologoById(long id) {
        return psicologoRepository.findById(id);
    }

    public Optional<PsicologoDto> findByNombre(String nombre) {
        return psicologoRepository.findByNombre(nombre).map(psicologoMapper::toDTO);
    }

    public PsicologoDto savePsicologo(PsicologoDto psicologo) {
        Psicologo psicologoEntity = psicologoMapper.toEntity(psicologo, rolService);
        PsicologoDto psicologoDTO = psicologoMapper.toDTO(psicologoRepository.save(psicologoEntity));
        return psicologoDTO;
    }

    public void deletePsicologo(long id) {
        psicologoRepository.deleteById(id);
    }

    public Optional<PsicologoDto> updatePsicologo(long id, PsicologoDto psicologo) {
        return psicologoRepository.findById(id).map(oldPsicologo -> {
            oldPsicologo.setNombre(psicologo.nombre());
            oldPsicologo.setApellido(psicologo.apellido());
            oldPsicologo.setRol(rolRepository.findById(psicologo.rol()).orElse(null));
            oldPsicologo.setCorreoElectronico(psicologo.correoElectronico());
            oldPsicologo.setPassword(psicologo.password());
            oldPsicologo.setEdad(psicologo.edad());
            oldPsicologo.setTelefono(psicologo.telefono());
            oldPsicologo.setSexo(psicologo.sexo());
            oldPsicologo.setFechaDeNacimiento(psicologo.fechaDeNacimiento());
            oldPsicologo.setAñosDeExperiencia(psicologo.añosDeExperiencia());
            oldPsicologo.setEspecialidad(psicologo.especialidad());
            oldPsicologo.setHorarioDeAtencion(psicologo.horarioDeAtencion());
            return psicologoRepository.save(oldPsicologo);
        }).map(psicologoMapper::toDTO);
    }
}