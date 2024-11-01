package com.data.safehaven.dtos;

import com.data.safehaven.entities.Psicologo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PsicologoMapper {
    Psicologo toEntity(PsicologoDto psicologoDto);
    PsicologoDto toDTO(Psicologo psicologo);

    @Mapping(target = "id", ignore = true)
    PsicologoDto toDTOWithoutId(Psicologo psicologo);
}

