package com.data.safehaven.services;

import com.data.safehaven.dtos.RolDto;
import com.data.safehaven.dtos.RolMapper;
import com.data.safehaven.entities.Rol;
import com.data.safehaven.repositories.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolService(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    public List<RolDto> findAll() {
        return rolRepository.findAll().stream().map(r -> rolMapper.toDTO(r)).collect(Collectors.toList());
    }

    public Optional<RolDto> findById(long id) {
        return rolRepository.findById(id).map(rolMapper::toDTO);
    }
    public Rol findRoleById(long id) {
        return rolRepository.findById(id).orElse(null);
    }


    public Optional<RolDto> findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre).map(rolMapper::toDTO);
    }


    public RolDto saveRol(RolDto rol) {
        Rol rolEntity = rolMapper.toEntity(rol);
        RolDto rolDTO = rolMapper.toDTO(rolRepository.save(rolEntity));
        return rolDTO;
    }


    public void deleteRol(long id) {
        rolRepository.deleteById(id);
    }

    public Optional<RolDto> updateRol(long id, RolDto rol) {
        return rolRepository.findById(id).map(oldRol -> {
            oldRol.setNombre(rol.nombre());
            oldRol.setDescripcion(rol.descripcion());
            return rolRepository.save(oldRol);
        }).map(rolMapper::toDTO);
    }
}
