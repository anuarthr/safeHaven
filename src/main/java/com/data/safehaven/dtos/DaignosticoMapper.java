package com.data.safehaven.dtos;

import com.data.safehaven.entities.Diagnostico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface DiagnosticoMapper {
    Diagnostico toEntity(DiagnosticoDto diagnosticoDto);
    DiagnosticoDto toDTO(Diagnostico diagnostico);

    @Mapping(target = "id", ignore = true)
    DiagnosticoDto toDTOWithoutId(Diagnostico diagnostico);
}

