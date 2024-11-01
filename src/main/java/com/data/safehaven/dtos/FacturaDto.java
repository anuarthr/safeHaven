package com.data.safehaven.dtos;

import com.data.safehaven.entities.Cita;
import com.data.safehaven.entities.Paciente;

import java.util.Date;

public record FacturaDto(
        Long id,
        double monto,
        String insertBy,
        String updateBy,
        Date fechaDePago,
        Date insertAt,
        Date updateAt,
        Cita cita,
        Paciente paciente
) {}

