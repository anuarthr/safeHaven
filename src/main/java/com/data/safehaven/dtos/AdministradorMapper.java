package com.data.safehaven.dtos;

import com.data.safehaven.entities.Administrador;
import com.data.safehaven.entities.Rol;
import com.data.safehaven.services.RolService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {
    @Mapping(source = "rol", target = "rol", qualifiedByName = "idToRol")
    Administrador toEntity(AdministradorDto administradorDto,@Context RolService rolService);

    @Mapping(source = "rol.id", target = "rol")
    AdministradorDto toDTO(Administrador administrador);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "rol.id", target = "rol")
    AdministradorDto toDTOWithoutId(Administrador administrador);

    @Named("idToRol")
    default Rol mapIdToRol(Long id, @Context RolService rolService) {
        return id != null ? rolService.findRoleById(id): null;
    }
}
