package com.data.safehaven.dtos;

import com.data.safehaven.entities.Cita;
import com.data.safehaven.entities.Consultorio;
import com.data.safehaven.entities.Paciente;
import com.data.safehaven.entities.Psicologo;
import com.data.safehaven.services.ConsultorioService;
import com.data.safehaven.services.PacienteService;
import com.data.safehaven.services.PsicologoService;
import org.mapstruct.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Mapper(componentModel = "spring")
public interface CitaMapper {

    @Mapping(source = "paciente", target = "paciente", qualifiedByName = "idToPaciente")
    @Mapping(source = "psicologo", target = "psicologo", qualifiedByName = "idToPsicologo")
    @Mapping(source = "consultorio", target = "consultorio", qualifiedByName = "idToConsultorio")
    Cita toEntity(CitaDto citaDto, @Context PacienteService pacienteService, @Context ConsultorioService consultorioService, @Context PsicologoService psicologoService);

    @Mapping(source = "paciente.id", target = "paciente")
    @Mapping(source = "psicologo.id", target = "psicologo")
    @Mapping(source = "consultorio.id", target = "consultorio")
    CitaDto toDTO(Cita cita);

    @Mapping(source = "paciente.id", target = "paciente")
    @Mapping(source = "psicologo.id", target = "psicologo")
    @Mapping(source = "consultorio.id", target = "consultorio")
    @Mapping(target = "id", ignore = true)
    CitaDto toDTOWithoutId(Cita cita);

    @Named("idToPaciente")
    default Paciente mapIdToPaciente(Long id, @Context PacienteService pacienteService) {
        return id != null ? pacienteService.findPacienteById(id).orElse(null) : null;
    }

    @Named("idToPsicologo")
    default Psicologo mapIdToPsicologo(Long id, @Context PsicologoService psicologoService) {
        return id != null ? psicologoService.findPsicologoById(id).orElse(null) : null;
    }

    @Named("idToConsultorio")
    default Consultorio mapIdToConsultorio(Long id, @Context ConsultorioService consultorioService) {
        return id != null ? consultorioService.findConsultorioById(id).orElse(null) : null;
    }
}

