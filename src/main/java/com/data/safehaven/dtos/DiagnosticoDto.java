package com.data.safehaven.dtos;

import com.data.safehaven.entities.Paciente;
import com.data.safehaven.entities.Psicologo;

import java.util.Date;

public record DiagnosticoDto(Long id,
                             String descripcion,
                             Date fecha,
                             Paciente paciente,
                             Psicologo psicologo) {
}
