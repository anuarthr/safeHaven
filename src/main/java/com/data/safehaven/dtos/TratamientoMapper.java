package com.data.safehaven.dtos;

import com.data.safehaven.entities.Tratamiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TratamientoMapper {
    Tratamiento toEntity(TratamientoDto tratamientoDto);
    TratamientoDto toDTO(Tratamiento tratamiento);

    @Mapping(target = "id", ignore = true)
    TratamientoDto toDTOWithoutId(Tratamiento tratamiento);
}

