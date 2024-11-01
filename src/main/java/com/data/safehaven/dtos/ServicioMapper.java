package com.data.safehaven.dtos;

import com.data.safehaven.entities.Servicio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicioMapper {
    Servicio toEntity(ServicioDto servicioDto);
    ServicioDto toDTO(Servicio servicio);

    @Mapping(target = "id", ignore = true)
    ServicioDto toDTOWithoutId(Servicio servicio);
}

