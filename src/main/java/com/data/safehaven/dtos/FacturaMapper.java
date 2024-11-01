package com.data.safehaven.dtos;

import com.data.safehaven.entities.Factura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
    Factura toEntity(FacturaDto facturaDto);
    FacturaDto toDTO(Factura factura);

    @Mapping(target = "id", ignore = true)
    FacturaDto toDTOWithoutId(Factura factura);
}

