package com.data.safehaven.services;

import com.data.safehaven.dtos.AdministradorDto;
import com.data.safehaven.dtos.AdministradorMapper;
import com.data.safehaven.entities.Administrador;
import com.data.safehaven.repositories.AdministradorRepository;
import com.data.safehaven.repositories.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;
    private final RolService rolService;
    private final RolRepository rolRepository;

    public AdministradorService(AdministradorRepository administradorRepository, AdministradorMapper administradorMapper, RolService rolService, RolRepository rolRepository) {
        this.administradorRepository = administradorRepository;
        this.administradorMapper = administradorMapper;
        this.rolService = rolService;
        this.rolRepository = rolRepository;
    }

    public List<AdministradorDto> findAll() {
        return administradorRepository.findAll().stream().map(p -> administradorMapper.toDTO(p)).collect(Collectors.toList());
    }

    public Optional<AdministradorDto> findById(long id) {
        return administradorRepository.findById(id).map(administradorMapper::toDTO);
    }

    public Optional<AdministradorDto> findByNombre(String nombre) {
        return administradorRepository.findByNombre(nombre).map(administradorMapper::toDTO);
    }


    public AdministradorDto saveAdministrador(AdministradorDto administrador) {
        Administrador administradorEntity = administradorMapper.toEntity(administrador, rolService);
        AdministradorDto admnistradorDTO = administradorMapper.toDTO(administradorRepository.save(administradorEntity));
        return admnistradorDTO;
    }


    public void deleteAdministrador(long id) {
        administradorRepository.deleteById(id);
    }

    public Optional<AdministradorDto> updateAdministrador(long id, AdministradorDto administrador) {
        return administradorRepository.findById(id).map(oldAdministrador -> {
            oldAdministrador.setNombre(administrador.nombre());
            oldAdministrador.setApellido(administrador.apellido());
            oldAdministrador.setTelefono(administrador.telefono());
            oldAdministrador.setEdad(administrador.edad());
            oldAdministrador.setRol(rolRepository.findById(administrador.rol()).orElse(null));
            oldAdministrador.setCargo(administrador.cargo());
            oldAdministrador.setCorreoElectronico(administrador.correoElectronico());
            oldAdministrador.setFechaDeNacimiento(administrador.fechaDeNacimiento());
            oldAdministrador.setSexo(administrador.sexo());
            oldAdministrador.setPassword(administrador.password());
            return administradorRepository.save(oldAdministrador);
        }).map(administradorMapper::toDTO);
}
}
