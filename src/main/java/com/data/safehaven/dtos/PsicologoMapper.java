package com.data.safehaven.dtos;

import com.data.safehaven.entities.Psicologo;
import com.data.safehaven.entities.Rol;
import com.data.safehaven.services.RolService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PsicologoMapper {
    @Mapping(source = "rol", target = "rol", qualifiedByName = "idToRol")
    Psicologo toEntity(PsicologoDto psicologoDto, @Context RolService rolService);

    @Mapping(source = "rol.id", target = "rol")
    PsicologoDto toDTO(Psicologo psicologo);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "rol.id", target = "rol")
    PsicologoDto toDTOWithoutId(Psicologo psicologo);

    @Named("idToRol")
    default Rol mapIdToRol(Long id, @Context RolService rolService) {
        return id != null ? rolService.findRoleById(id): null;
    }
}

