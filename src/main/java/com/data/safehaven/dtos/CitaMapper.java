package com.data.safehaven.dtos;

import com.data.safehaven.entities.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    Cita toEntity(CitaDto citaDto);
    CitaDto toDTO(Cita cita);

    @Mapping(target = "id", ignore = true)
    CitaDto toDTOWithoutId(Cita cita);
}
