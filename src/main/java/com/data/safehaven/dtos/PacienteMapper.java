package com.data.safehaven.dtos;

import com.data.safehaven.entities.Paciente;
import com.data.safehaven.entities.Rol;
import com.data.safehaven.services.RolService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public interface PacienteMapper {

    @Mapping(source = "rol", target = "rol", qualifiedByName = "idToRol")
    Paciente toEntity(PacienteDto pacienteDto, @Context RolService rolService);
    @Mapping(source = "rol.id", target = "rol")
    PacienteDto toDTO(Paciente paciente);
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "rol.id", target = "rol")
    PacienteDto toDTOWithoutId(Paciente paciente);

    @Named("idToRol")
    default Rol mapIdToRol(Long id, @Context RolService rolService) {
        return id != null ? rolService.findRoleById(id): null;
    }
}