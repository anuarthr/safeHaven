package com.data.safehaven.dtos;

import com.data.safehaven.entities.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolMapper {
    Rol toEntity(RolDto rolDto);
    RolDto toDTO(Rol rol);

    @Mapping(target = "id", ignore = true)
    RolDto toDTOWithoutId(Rol rol);
}
