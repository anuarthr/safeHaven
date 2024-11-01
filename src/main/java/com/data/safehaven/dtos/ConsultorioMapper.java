package com.data.safehaven.dtos;

import com.data.safehaven.entities.Consultorio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultorioMapper {
    Consultorio toEntity(ConsultorioDto consultorioDto);
    ConsultorioDto toDTO(Consultorio consultorio);

    @Mapping(target = "id", ignore = true)
    ConsultorioDto toDTOWithoutId(Consultorio consultorio);
}
