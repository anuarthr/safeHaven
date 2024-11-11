package com.data.safehaven.services;

import com.data.safehaven.dtos.CitaDto;
import com.data.safehaven.dtos.CitaMapper;
import com.data.safehaven.entities.Cita;
import com.data.safehaven.repositories.CitaRepository;
import com.data.safehaven.repositories.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitaService {
    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;
    private final RolRepository rolRepository;
    private final RolService rolService;

    public CitaService(CitaRepository citaRepository, CitaMapper citaMapper, RolRepository rolRepository, RolService rolService) {
        this.citaRepository = citaRepository;
        this.citaMapper = citaMapper;
        this.rolRepository = rolRepository;
        this.rolService = rolService;
    }

    public List<CitaDto> findAll() {
        return citaRepository.findAll().stream().map(p -> citaMapper.toDTO(p)).collect(Collectors.toList());
    }

    public Optional<CitaDto> findById(long id) {
        return citaRepository.findById(id).map(citaMapper::toDTO);
    }
//
//    public Optional<CitaDto> findByNombre(String nombre) {
//        return citaRepository.findByNombre(nombre).map(citaMapper::toDTO);
//    }

    public CitaDto saveCita(CitaDto cita) {
        Cita citaEntity = citaMapper.toEntity(cita);
        CitaDto citaDTO = citaMapper.toDTO(citaRepository.save(citaEntity));
        return citaDTO;
    }

    public void deleteCita(long id) {
        citaRepository.deleteById(id);
    }

    public Optional<CitaDto> updateCita(long id, CitaDto cita) {
        return citaRepository.findById(id).map(oldCita -> {
            oldCita.setConsultorio(cita.consultorio());
            oldCita.setFecha(cita.fecha());
            oldCita.setMotivo(cita.motivo());
            oldCita.setHora(cita.hora());
            oldCita.setDuracion(cita.duracion());
            oldCita.setTipoCita(cita.tipoCita());
            return citaRepository.save(oldCita);
        }).map(citaMapper::toDTO);
    }
}
