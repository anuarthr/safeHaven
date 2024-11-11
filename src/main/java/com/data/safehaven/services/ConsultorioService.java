package com.data.safehaven.services;

import com.data.safehaven.dtos.ConsultorioDto;
import com.data.safehaven.dtos.ConsultorioMapper;
import com.data.safehaven.entities.Consultorio;
import com.data.safehaven.repositories.ConsultorioRepository;
import com.data.safehaven.repositories.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultorioService {
    private final ConsultorioRepository consultorioRepository;
    private final ConsultorioMapper consultorioMapper;
    private final RolRepository rolRepository;
    private final RolService rolService;

    public ConsultorioService(ConsultorioRepository consultorioRepository, ConsultorioMapper consultorioMapper, RolRepository rolRepository, RolService rolService) {
        this.consultorioRepository = consultorioRepository;
        this.consultorioMapper = consultorioMapper;
        this.rolRepository = rolRepository;
        this.rolService = rolService;
    }

    public List<ConsultorioDto> findAll() {
        return consultorioRepository.findAll().stream().map(p -> consultorioMapper.toDTO(p)).collect(Collectors.toList());
    }

    public Optional<ConsultorioDto> findById(long id) {
        return consultorioRepository.findById(id).map(consultorioMapper::toDTO);
    }

    public Optional<Consultorio> findConsultorioById(long id) {
        return consultorioRepository.findById(id);
    }

    public Optional<ConsultorioDto> findByNombre(String nombre) {
        return consultorioRepository.findByNombre(nombre).map(consultorioMapper::toDTO);
    }

    public ConsultorioDto saveConsultorio(ConsultorioDto consultorio) {
        Consultorio consultorioEntity = consultorioMapper.toEntity(consultorio);
        ConsultorioDto consultorioDTO = consultorioMapper.toDTO(consultorioRepository.save(consultorioEntity));
        return consultorioDTO;
    }

    public void deleteConsultorio(long id) {
        consultorioRepository.deleteById(id);
    }

    public Optional<ConsultorioDto> updateConsultorio(long id, ConsultorioDto consultorio) {
        return consultorioRepository.findById(id).map(oldConsultorio -> {
            oldConsultorio.setNombre(consultorio.nombre());
            oldConsultorio.setCapacidad(consultorio.capacidad());
            oldConsultorio.setTipo(consultorio.tipo());
            oldConsultorio.setHorarioDeApertura(consultorio.horarioDeApertura());
            oldConsultorio.setHorarioDeCierre(consultorio.horarioDeCierre());
            oldConsultorio.setCapacidad(consultorio.capacidad());
            oldConsultorio.setActivo(consultorio.activo());
            return consultorioRepository.save(oldConsultorio);
        }).map(consultorioMapper::toDTO);
    }
}
