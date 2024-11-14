package com.data.safehaven.dtos;

import com.data.safehaven.entities.Usuario;
import com.data.safehaven.entities.Rol;
import com.data.safehaven.services.RolService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(source = "rol", target = "rol", qualifiedByName = "idToRol")
    Usuario toEntity(UsuarioDto usuarioDto, @Context RolService rolService);

    @Mapping(source = "rol.id", target = "rol")
    UsuarioDto toDTO(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "rol.id", target = "rol")
    UsuarioDto toDTOWithoutId(Usuario usuario);

    @Named("idToRol")
    default Rol mapIdToRol(Long id, @Context RolService rolService) {
        if (id == null) {
            return rolService.findRoleById(id);
        }
        return rolService.findRoleById(id);
    }

}
