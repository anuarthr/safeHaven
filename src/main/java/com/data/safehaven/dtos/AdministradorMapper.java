package com.data.safehaven.dtos;

import com.data.safehaven.entities.Administrador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {
    Administrador toEntity(AdministradorDto administradorDto);
    AdministradorDto toDTO(Administrador administrador);

    @Mapping(target = "id", ignore = true)
    AdministradorDto toDTOWithoutId(Administrador administrador);
}
